package com.yousoft.stram.service.beans;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yousoft.stram.domain.application.Email;
import com.yousoft.stram.exception.StramException;
import com.yousoft.stram.service.beans.service.EmailNotificationService;
import com.yousoft.stram.service.beans.service.ManagerParserDocumentService;
import com.yousoft.stram.service.beans.service.ManagerProcessDocumentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/data-config.xml", "file:src/main/webapp/WEB-INF/spring-config.xml"})
public class ProcessEmailToPersistence {

    @Autowired
    EmailNotificationService emailNotificationService;

    @Autowired
    ManagerProcessDocumentService managerProcessDocumentService;
    
    @Autowired
    ManagerParserDocumentService managerParserDocumentService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void ProcessStram() {
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
        assertNotNull(emails);
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
