/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.persistence.dao;

import com.yousoft.stram.domain.StatusVehicule;
import com.yousoft.stram.domain.Vehicule;

/**
 *
 * @author jguinart
 */

public interface StatusVehiculeMapper {
    
    void insertStatusVehicule(Vehicule vehicule);
    
    StatusVehicule findById(Vehicule vehicule);

}
