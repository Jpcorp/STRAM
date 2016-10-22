/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.view.beans;

import com.yousoft.stram.exception.StramViewException;
import com.yousoft.stram.view.business.ProcessRecoveryService;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author jguinart
 */
@ManagedBean(name = "recoverAccountBean")
@ViewScoped
public class RecoverAccountBean implements Serializable {

    /**
     * Springs beans
     */
    //@ManagedProperty(value = "#{recoveryService}")
    // private ProcessRecoveryService recoveryService;
    private String email;

    /**
     * Creates a new instance of RecoverAccountBean
     */
    public RecoverAccountBean() {
    }

    public void getRecoveryPasswd() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Debe Ingresar un correo electronico " + getEmail()));
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
