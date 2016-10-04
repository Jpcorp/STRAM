/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.service.beans.service;

import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.exception.StramException;

/**
 *
 * @author jguinart
 */
public interface ManagerDocumentVehiculeService {
    
    void saveDocument(Vehicule vehicule) throws StramException;
}
