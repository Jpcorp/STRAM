/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.view;

import com.yousoft.stram.view.utils.Configuration;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedProperty;


/**
 *
 * @author jguinart
 */
@ManagedBean(name = "app")
@ApplicationScoped
public class applicationBean {
	
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
    
}
