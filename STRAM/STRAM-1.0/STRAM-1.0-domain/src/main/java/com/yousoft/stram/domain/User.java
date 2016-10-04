/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jguinart
 */
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.NONE)
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @XmlAttribute
    private String id;
    
    @XmlAttribute
    private String email;
    
    @XmlAttribute
    private String passwd;

    public User() {
    }

    public User(String id, String email, String passwd) {
        this.id = id;
        this.email = email;
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", passwd=" + passwd + '}';
    }
    
    
    
    
}
