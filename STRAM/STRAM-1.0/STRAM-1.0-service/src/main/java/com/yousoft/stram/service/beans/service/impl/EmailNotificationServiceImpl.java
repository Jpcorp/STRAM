/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.service.beans.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yousoft.stram.domain.application.Email;
import com.yousoft.stram.service.beans.service.EmailNotificationService;

/**
 * beans encargado de conectar con correo electronico
 *
 * @author jguinart
 */
@Service
public class EmailNotificationServiceImpl implements EmailNotificationService {

    private static final Logger logger = Logger.getLogger(EmailNotificationServiceImpl.class);

    @Value("${mail.smtp.host}")
    private String mailSmtpHost;

    @Value("${mail.smtp.socketFactory.port}")
    private String mailSmtpSocketFactoryPort;

    @Value("${mail.smtp.socketFactory.class}")
    private String mailSmtpSocketFactoryClass;

    @Value("${mail.smtp.auth}")
    private String mailSmtpAuth;

    @Value("${mail.smtp.port}")
    private String mailSmtpPort;

    @Value("${mail.smtp.username}")
    private String mailSmtpUser;

    @Value("${mail.smtp.passwd}")
    private String mailSmtPasswd;

    @Value("${mail.smtp.inbox}")
    private String inboxToCheck;

    @Value("${mail.smtp.inbox.max}")
    private String mailSmtpInboxMax;

    @Value("${mail.smtp.remove.tags.regex}")
    private String regexHTML;

    @Value("${mail.smtp.from.address}")
    private String fromAddress;

    private final static String NEW_LINE = "\r\n";

    private Session session;

    private Store store;

    @PostConstruct
    public void init() {
        connect();
    }

    private void connect() {
        try {
            long startTime = System.nanoTime();
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", mailSmtpHost);
            props.setProperty("mail.smtp.socketFactory.port", mailSmtpSocketFactoryPort);
            props.setProperty("mail.smtp.socketFactory.class", mailSmtpSocketFactoryClass);
            props.setProperty("mail.smtp.auth", mailSmtpAuth);
            props.setProperty("mail.smtp.port", mailSmtpPort);
            session = Session.getDefaultInstance(props, null);
            store = session.getStore("imaps");
            store.connect(this.mailSmtpHost, this.mailSmtpUser, this.mailSmtPasswd);
            long endTime = System.nanoTime();
            logger.debug("Store connection - Elapsed time (ns) : " + (endTime - startTime));
        } catch (MessagingException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public List<Email> getEmailsLatestInbox() {
        List<Email> emails = new ArrayList<>();
        if (!store.isConnected()) {
            logger.info("Conectandose con bandeja de entrada...");
            connect();
        }
        try {
            final Folder inbox = store.getFolder(inboxToCheck);
            inbox.open(Folder.READ_ONLY);
            final Message[] messages = getMessages(inbox);
            long startTime = System.nanoTime();
            for (Message message : messages) {
                if (filterFromField(message, fromAddress)) {
                    Email email = getMessageContent(message.getSubject(),
                            message.getContent(), message.getSentDate().getTime());
                    logger.debug("Email: " + email.toString());
                    emails.add(email);
                } else {
                    Address[] addrs = message.getFrom();
                    logger.info("invalid address : " + addrs[0].toString());
                }

                logger.info("Deleting email from inbox");
                // deleteItems(message);
            }
            long endTime = System.nanoTime();
            logger.debug("Processing messages - Elapsed time (ns) : " + (endTime - startTime));
            inbox.close(true);
        } catch (MessagingException | IOException e) {
            logger.error(e.getMessage());
        }
        return emails;
    }

    protected Message[] getMessages(Folder folder) throws MessagingException {

        Message[] messages = {};
        int startIndex = 1;
        int maxAmountOfMessages;
        try {
            maxAmountOfMessages = Integer.parseInt(mailSmtpInboxMax);
        } catch (NumberFormatException e) {
            logger.error("Error : MailService.inbox.max property not found");
            maxAmountOfMessages = 0;
        }
        int totalMessageCount;
        totalMessageCount = folder.getMessageCount();
        if (totalMessageCount < maxAmountOfMessages) {
            maxAmountOfMessages = totalMessageCount;
        }

        if (maxAmountOfMessages > 0) {
            messages = folder.getMessages(startIndex, maxAmountOfMessages);
        }
        return messages;
    }

    private Email getMessageContent(String subject, Object content, long time) {
        Email result = new Email(subject, time);
        result.setBody(getMessageContentBody(content));
        result.setAttachments(getMessageContentAttachments(content));
        return result;
    }

    private String getMessageContentBody(Object content) {
        String body = "";
        try {
            if (content instanceof String) {
                body = (String) content;
            } else {
                final Multipart mp = (Multipart) content;
                //Assume it only contains one part (no attachments)
                final BodyPart part = mp.getBodyPart(0);
                if (part != null) {
                    body = (String) part.getContent().toString();
                    body = body.replaceAll(regexHTML, "");
                    body = body.replaceAll(NEW_LINE, " ");
                }
            }
        } catch (IOException | MessagingException e) {
            logger.error("Coudn't get message content from email message");
        }

        return body;
    }

    private List<File> getMessageContentAttachments(Object content) {
        List<File> attachments = new ArrayList<>();
        try {
            final Multipart mp = (Multipart) content;
            logger.debug("mp.getCount() --> " + mp.getCount());
            for (int i = 0; i < mp.getCount(); i++) {
                BodyPart bodyPart = mp.getBodyPart(i);

                if (!Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition())
                        && !StringUtils.isNotBlank(bodyPart.getFileName())) {
                    continue; // dealing with attachments only
                }
                InputStream is = bodyPart.getInputStream();
                File f = new File("/tmp/" + bodyPart.getFileName());
                FileOutputStream fos = new FileOutputStream(f);
                byte[] buf = new byte[4096];
                int bytesRead;
                while ((bytesRead = is.read(buf)) != -1) {
                    fos.write(buf, 0, bytesRead);
                }
                fos.close();
                attachments.add(f);
            }
            return attachments;

        } catch (MessagingException | IOException e) {
            logger.error(e.getMessage());
        }
        return attachments;
    }

    /**
     * Determine whether from email address is valid (within LAN domain)
     *
     * @param message
     * @param fromAddress
     * @return
     * @throws MessagingException
     */
    protected boolean filterFromField(Message message, String fromAddress) throws MessagingException {

        Address searchFrom = new InternetAddress(fromAddress);
        return Arrays.asList(message.getFrom()).contains(searchFrom);
    }

    /*
     * Delete email (message) from Mail Server's Inbox
     * 
     * @param message
     * 
     * @throws MessagingException
     */
    public void deleteItems(Message message) {

        try {
            message.setFlag(Flags.Flag.DELETED, true);
        } catch (MessagingException e) {
            logger.error(e.getMessage());
        }
    }

}
