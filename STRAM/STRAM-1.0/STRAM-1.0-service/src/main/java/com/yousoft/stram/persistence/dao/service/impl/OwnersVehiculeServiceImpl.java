/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.persistence.dao.service.impl;

import com.yousoft.stram.domain.DetailsOwners;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.yousoft.stram.domain.OwnersVehicule;
import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.exception.StramException;
import com.yousoft.stram.persistence.dao.OwnersVehiculeMapper;
import com.yousoft.stram.persistence.dao.service.OwnersVehiculeService;

/**
 *
 * @author jguinart
 */

public class OwnersVehiculeServiceImpl implements OwnersVehiculeService {

    private static final Logger logger = Logger.getLogger(OwnersVehiculeServiceImpl.class);

    private static final String NOT_INSERT = "Error, insert owners vehicule";

    private static final String NOT_DATA_FOUND = "Error, to search owners vehicule";

    private OwnersVehiculeMapper ownersVehiculeMapper;

    public void setOwnersVehiculeMapper(OwnersVehiculeMapper ownersVehiculeMapper) {
        this.ownersVehiculeMapper = ownersVehiculeMapper;
    }

    @Override
    public int insertOwnersVehicule(Vehicule vehicule) throws StramException {
        int result = 0;
        try {
            ownersVehiculeMapper.insertOwnersVehicule(vehicule);
            result = 1;
        } catch (Exception e) {
            logger.error(NOT_INSERT, e);
            throw new StramException(NOT_INSERT, e);
        }
        return result;
    }

    @Override
    public OwnersVehicule getOwnersVehiculeByRun(Vehicule vehicule) throws StramException {
        OwnersVehicule ownersVehicule = null;
        try {
            ownersVehicule = ownersVehiculeMapper.findByRun(vehicule);
            if(ownersVehicule != null) {
                DetailsOwners detailsOwners = vehicule.getDetailsOwners();
                detailsOwners.setOwnersVehicule(ownersVehicule);
                vehicule.setDetailsOwners(detailsOwners);
            }
        } catch (Exception e) {
            logger.error(NOT_DATA_FOUND, e);
            throw new StramException(NOT_DATA_FOUND, e);
        }
        return ownersVehicule;

    }

}
