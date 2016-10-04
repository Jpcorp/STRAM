/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.persistence.dao.service;

import com.yousoft.stram.domain.ColorsVehicule;
import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.exception.StramException;
import org.springframework.stereotype.Service;

/**
 *
 * @author jguinart
 */

public interface ColorsVehiculeService {
    
    int insertColorsVehicule(Vehicule vehicule) throws StramException;
    
    ColorsVehicule getColorsVehiculeByName(Vehicule vehicule) throws StramException;
    
}
