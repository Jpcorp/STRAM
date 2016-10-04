/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.persistence.dao;

import static org.junit.Assert.assertNull;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.yousoft.stram.domain.StatusVehicule;
import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.persistence.utils.VehiculeUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/data-config.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class StatusVehiculeDAOImplTest {

    @Resource
    StatusVehiculeMapper statusVehiculeMapper;
    
    VehiculeUtils veh = new VehiculeUtils();
    
    
    @Test
    public void newBrandsVehicule() {
        Vehicule vehicule = veh.getVehicule();      
        
        StatusVehicule statusVehicules = statusVehiculeMapper.findById(vehicule);
        if (statusVehicules == null) {
            statusVehiculeMapper.insertStatusVehicule(vehicule);
        } else {
        	statusVehicules = null;
        }
        assertNull(statusVehicules);
    }

}
