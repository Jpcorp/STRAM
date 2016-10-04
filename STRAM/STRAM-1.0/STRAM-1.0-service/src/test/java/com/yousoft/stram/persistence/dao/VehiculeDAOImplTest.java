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

import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.persistence.utils.VehiculeUtils;
import java.text.ParseException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/data-config.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class VehiculeDAOImplTest {

    @Resource
    VehiculeMapper vehiculeMapper;
    
    VehiculeUtils veh = new VehiculeUtils();
    
    @Test
    public void newVehicule() throws ParseException {
        Vehicule vehicule = veh.getVehicule();
                
        Vehicule vehicules = vehiculeMapper.getVehiculePatente(vehicule);
        if (vehicules == null) {
        	vehiculeMapper.insertVehicule(vehicule);
        } else {
        	vehicules = null;
        }
        assertNull(vehicules);
    }

}
