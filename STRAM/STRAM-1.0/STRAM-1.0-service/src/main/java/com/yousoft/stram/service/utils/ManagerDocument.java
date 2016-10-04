/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.service.utils;

import com.yousoft.stram.exception.StramException;

/**
 *
 * @author jguinart
 */
public abstract class ManagerDocument {
    
    public final int STATUS_INITIAL_VEHICULE = 1;
    public final String STATUS_DSC_INITIAL_VEHICULE = "INGRESADO_STRAM";
    
    public void init() throws StramException {}
    
}
