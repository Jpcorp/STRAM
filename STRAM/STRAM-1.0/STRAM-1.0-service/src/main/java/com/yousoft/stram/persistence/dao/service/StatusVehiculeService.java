/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.persistence.dao.service;

import com.yousoft.stram.domain.StatusVehicule;
import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.exception.StramException;

/**
 *
 * @author jguinart
 */
public interface StatusVehiculeService {
    
    int insertStatusVehicule(Vehicule vehicule) throws StramException;
    
    StatusVehicule getStatusById(Vehicule vehicule) throws StramException;
    
}
