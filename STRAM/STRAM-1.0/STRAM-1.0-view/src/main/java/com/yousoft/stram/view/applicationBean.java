/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author jguinart
 */
@ManagedBean(name = "app")
@ApplicationScoped
public class applicationBean {
    
    public final String nameApp = "STRAM";
    
    public final String versionApp = "1.0";

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public applicationBean() {
    }

    public String getNameApp() {
        return nameApp;
    }

    public String getVersionApp() {
        return versionApp;
    }
    
    
    
}
