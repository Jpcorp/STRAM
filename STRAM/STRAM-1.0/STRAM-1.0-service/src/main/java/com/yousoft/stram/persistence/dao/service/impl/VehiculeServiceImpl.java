/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.persistence.dao.service.impl;

import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.exception.StramException;
import com.yousoft.stram.persistence.dao.VehiculeMapper;
import com.yousoft.stram.persistence.dao.service.VehiculeService;
import org.apache.log4j.Logger;

/**
 *
 * @author jguinart
 */
public class VehiculeServiceImpl implements VehiculeService {

    private static final Logger logger = Logger.getLogger(VehiculeServiceImpl.class);

    private static final String NOT_INSERT = "Error, insert vehicule";

    private static final String NOT_DATA_FOUND = "Error, to search vehicule";

    private VehiculeMapper vehiculeMapper;

    public void setVehiculeMapper(VehiculeMapper vehiculeMapper) {
        this.vehiculeMapper = vehiculeMapper;
    }

    @Override
    public int insertBrandsVehicule(Vehicule vehicule) throws StramException {
        int result = 0;
        try {
            vehiculeMapper.insertVehicule(vehicule);
            result = 1;
        } catch (Exception e) {
            logger.error(NOT_INSERT, e);
            throw new StramException(NOT_INSERT, e);
        }
        return result;
    }

    @Override
    public Vehicule getVehiculePatente(Vehicule param) throws StramException {
        Vehicule vehicule = null;
        try {
            
           vehicule = vehiculeMapper.getVehiculePatente(param);
        } catch (Exception e) {
            logger.error(NOT_DATA_FOUND, e);
            throw new StramException(NOT_DATA_FOUND, e);
        }
        return vehicule;
    }
    
}
