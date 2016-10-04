/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.service.timer.impl;

import com.yousoft.stram.domain.application.Email;
import com.yousoft.stram.exception.StramException;
import com.yousoft.stram.service.beans.service.EmailNotificationService;
import com.yousoft.stram.service.beans.service.ManagerParserDocumentService;
import com.yousoft.stram.service.beans.service.ManagerProcessDocumentService;
import com.yousoft.stram.service.timer.services.MailNotificationTimerService;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 *
 * @author jguinart
 */
public class MailNotificationTimerImpl implements MailNotificationTimerService {
    
    @Autowired
    EmailNotificationService emailNotificationService;

    @Autowired
    ManagerProcessDocumentService managerProcessDocumentService;
    
    @Autowired
    ManagerParserDocumentService managerParserDocumentService;


    /**
     * Metodo para ejecutar el timer
     * @throws StramException Exception
     */
    @Override
    @Scheduled(cron = "${app.timer.email}")
    public void execute() throws StramException {
        System.out.println("Metodo se ejecutara cada 5 segundos. La hora es :: " + new Date());
        
        List<StringBuffer> actual = new ArrayList<>();
        List<Email> emails = getEMailsByService();
        for (Email email : emails) {
            for (File file : email.getAttachments()) {
                try {
                    actual.add(managerProcessDocumentService.getProcessDocument(file));
                } catch (StramException ex) {
                    actual = null;
                }
            }
            if (actual != null) {
                parserAllDocuments(actual);
            } else {
                System.out.println("size " + actual.size());
            }
        }
    }

    private List<Email> getEMailsByService() {
        return emailNotificationService.getEmailsLatestInbox();
    }

    private void parserAllDocuments(List<StringBuffer> actual) {
        for (StringBuffer doc : actual) {
            managerParserDocumentService.processDocumentCav(doc);
        }
    }
}
