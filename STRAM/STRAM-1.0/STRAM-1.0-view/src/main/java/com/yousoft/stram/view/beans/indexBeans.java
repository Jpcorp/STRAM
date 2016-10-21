/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.view.beans;

import com.yousoft.stram.view.busisness.AutentificateService;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;
/**
 *
 * @author jguinart
 *
@Component
@ManagedBean
@ViewScoped*/
@Component
@Scope("session")
@Qualifier("indexBeans")
public class indexBeans implements Serializable {
    
    private boolean accept;
    private String email;
    private String passwd;
    
    @Autowired
    AutentificateService autentificateService;

    public indexBeans() {
        
    }
    
    public void autenticate(){
        System.out.println("Hola : " + getEmail());
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd the passwd to set
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * @return the accept
     */
    public boolean isAccept() {
        return accept;
    }

    /**
     * @param accept the accept to set
     */
    public void setAccept(boolean accept) {
        this.accept = accept;
    }
    
    
}
