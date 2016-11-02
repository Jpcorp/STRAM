/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.view.utils;

import java.io.Serializable;

/**
 *
 * @author jguinart
 */
public class Configuration implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String nameApp;
	
    public String versionApp;

    /**
     * @return the nameApp
     */
    public String getNameApp() {
        return nameApp;
    }

    /**
     * @param nameApp the nameApp to set
     */
    public void setNameApp(String nameApp) {
        this.nameApp = nameApp;
    }

    /**
     * @return the versionApp
     */
    public String getVersionApp() {
        return versionApp;
    }

    /**
     * @param versionApp the versionApp to set
     */
    public void setVersionApp(String versionApp) {
        this.versionApp = versionApp;
    }
        
        
    
}
