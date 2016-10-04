/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.persistence.dao;

import com.yousoft.stram.domain.OwnersVehicule;
import com.yousoft.stram.domain.Vehicule;

/**
 *
 * @author jguinart
 */

public interface OwnersVehiculeMapper {
    
    void insertOwnersVehicule(Vehicule vehicule);
    
    OwnersVehicule findByRun(Vehicule vehicule);

}
