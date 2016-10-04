/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.service.beans.service;

import java.util.List;

import com.yousoft.stram.domain.application.Email;

/**
 *
 * @author jguinart
 */
public interface EmailNotificationService {
    
    public List<Email> getEmailsLatestInbox();
}
