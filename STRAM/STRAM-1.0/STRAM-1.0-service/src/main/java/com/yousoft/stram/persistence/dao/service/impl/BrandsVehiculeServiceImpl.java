/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.persistence.dao.service.impl;

import com.yousoft.stram.domain.BrandsVehicule;
import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.exception.StramException;
import com.yousoft.stram.persistence.dao.BrandsVehiculeMapper;
import com.yousoft.stram.persistence.dao.service.BrandsVehiculeService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author jguinart
 */

public class BrandsVehiculeServiceImpl implements BrandsVehiculeService {

    private static final Logger logger = Logger.getLogger(BrandsVehiculeServiceImpl.class);

    private static final String NOT_INSERT = "Error, insert brands vehicule";

    private static final String NOT_DATA_FOUND = "Error, to search brands vehicule";

    private BrandsVehiculeMapper brandsVehiculeMapper;

    public void setBrandsVehiculeMapper(BrandsVehiculeMapper brandsVehiculeMapper) {
        this.brandsVehiculeMapper = brandsVehiculeMapper;
    }

    @Override
    public int insertBrandsVehicule(Vehicule vehicule) throws StramException {
        int result = 0;
        try {
            brandsVehiculeMapper.insertBrandsVehicule(vehicule);
            result = 1;
        } catch (Exception e) {
            logger.error(NOT_INSERT, e);
            throw new StramException(NOT_INSERT, e);
        }
        return result;
    }

    @Override
    public BrandsVehicule getBrandsVehiculeByName(Vehicule vehicule) throws StramException {
        BrandsVehicule brandsVehicule = null;
        String name = vehicule.getModelsVehicule().getBrandsVehicule().getName();
        try {
            if (vehicule.getModelsVehicule().getBrandsVehicule().getName() != null 
                    && !vehicule.getModelsVehicule().getBrandsVehicule().getName().isEmpty()) {
                
                String bn = "%" + vehicule.getModelsVehicule().getBrandsVehicule().getName() + "%";
                vehicule.getModelsVehicule().getBrandsVehicule().setName(bn);
            }
            brandsVehicule = brandsVehiculeMapper.findByName(vehicule);
            vehicule.getModelsVehicule().getBrandsVehicule().setName(name);
            if (brandsVehicule != null) {
                vehicule.getModelsVehicule().setBrandsVehicule(brandsVehicule);
            }
        } catch (Exception e) {
            logger.error(NOT_DATA_FOUND, e);
            throw new StramException(NOT_DATA_FOUND, e);
        }
        return brandsVehicule;
    }
    
}
