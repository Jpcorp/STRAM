/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.persistence.dao;

import static org.junit.Assert.assertNull;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.yousoft.stram.domain.OwnersVehicule;
import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.persistence.utils.VehiculeUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/data-config.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class OwnersVehiculeDAOImplTest {
    
private static final Logger logger = Logger.getLogger(OwnersVehiculeDAOImplTest.class);


    @Resource
    OwnersVehiculeMapper ownersVehiculeMapper;
    
    VehiculeUtils veh = new VehiculeUtils();
    
    @Test
    public void newOwnersVehicule() {
        Vehicule vehicule = veh.getVehicule();
                
        OwnersVehicule ownersVehiculess = ownersVehiculeMapper.findByRun(vehicule);
        if (ownersVehiculess == null) {
                logger.info(vehicule.toString());
                ownersVehiculeMapper.insertOwnersVehicule(vehicule);
        } else {
        	ownersVehiculess = null;
        }
        assertNull(ownersVehiculess);
    }

}
