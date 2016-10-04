/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.persistence.dao.service;

import com.yousoft.stram.domain.TypesVehicule;
import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.exception.StramException;
import org.springframework.stereotype.Service;

/**
 *
 * @author jguinart
 */

public interface TypesVehiculeService {
    
    int inserTypesVehicule(Vehicule vehicule) throws StramException;
    
    TypesVehicule getTypesVehiculeByName(Vehicule vehicule) throws StramException;
    
}
