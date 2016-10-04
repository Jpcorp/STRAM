/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.persistence.dao.service;

import com.yousoft.stram.domain.OwnersVehicule;
import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.exception.StramException;

/**
 *
 * @author jguinart
 */
public interface OwnersVehiculeService {
    
    int insertOwnersVehicule(Vehicule vehicule) throws StramException;
    
    OwnersVehicule getOwnersVehiculeByRun(Vehicule vehicule) throws StramException;
    
}
