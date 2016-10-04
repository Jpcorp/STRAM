/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.persistence.dao;

import com.yousoft.stram.domain.BrandsVehicule;
import com.yousoft.stram.domain.ModelsVehicule;
import com.yousoft.stram.domain.TypesVehicule;
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
public class ModelsVehiculeDAOImplTest {

    @Resource
    ModelsVehiculeMapper modelsVehiculeMapper;   
    
    VehiculeUtils veh = new VehiculeUtils();
    
    @Test
    public void newModelsVehicule() {
        Vehicule vehicule = veh.getVehicule();        
        
        ModelsVehicule modelsVehicules = modelsVehiculeMapper.findByName(vehicule);
        if (modelsVehicules == null) {
            modelsVehiculeMapper.insertModelsVehicule(vehicule);
        } else {
        	modelsVehicules = null;
        }
        assertNull(modelsVehicules);
    }

}
