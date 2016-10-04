/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.persistence.dao;

import com.yousoft.stram.domain.DetailsOwners;
import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.persistence.utils.VehiculeUtils;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/data-config.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class DetailsOwnerDAOImplTest {

    @Resource
    DetailsOwnersMapper detailsOwnersMapper;
    
    VehiculeUtils veh = new VehiculeUtils();
    
    @Test
    public void newDetailsOwnersVehicule() {
        Vehicule vehicule = veh.getVehicule();
        
        DetailsOwners detailsOwnerss = detailsOwnersMapper.findById(vehicule);
        if (detailsOwnerss == null) {
            detailsOwnersMapper.insertDetailsOwners(vehicule);
        } else {
        	detailsOwnerss = null;
        }
        assertNull(detailsOwnerss);
    }

}
