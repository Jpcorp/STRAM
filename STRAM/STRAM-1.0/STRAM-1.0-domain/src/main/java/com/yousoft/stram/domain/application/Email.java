/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.domain.application;

import com.yousoft.stram.domain.Vehicule;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jguinart
 */
public class Email implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String subject;
    private String body;
    private Long fechSentEmail;
    private Date fechEntry;
    private List<File> attachments;
    private List<Vehicule> vehicules;

    public Email() {
    }

    public Email(String subject, long time) {
        this.subject = subject;
        this.fechSentEmail = time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getFechSentEmail() {
        return fechSentEmail;
    }

    public void setFechSentEmail(Long fechSentEmail) {
        this.fechSentEmail = fechSentEmail;
    }

    public List<File> getAttachments() {
        if (attachments == null) {
            attachments = new ArrayList<>();
        }
        return attachments;
    }

    public void setAttachments(List<File> attachments) {
        this.attachments = attachments;
    }
    
    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(List<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    @Override
    public String toString() {
        return "Email{" + "subject=" + subject + ", body=" + body + ", fechSentEmail=" + fechSentEmail + ", fechEntry=" + fechEntry + ", attachments=" + attachments + ", vehicules=" + vehicules + '}';
    }

        

}
