/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.view;

<<<<<<< HEAD
import com.yousoft.stram.view.utils.Configuration;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedProperty;

=======
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
>>>>>>> master

/**
 *
 * @author jguinart
 */
@ManagedBean(name = "app")
@ApplicationScoped
public class applicationBean {
<<<<<<< HEAD
	
    @ManagedProperty(value="#{config}")
    private Configuration config;
    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public applicationBean() {                
    }
    
    
    

    /**
     * @return the config
     */
    public Configuration getConfig() {
        return config;
    }

    /**
     * @param config the config to set
     */
    public void setConfig(Configuration config) {
        this.config = config;
    }
=======
    
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
    
    
>>>>>>> master
    
}
