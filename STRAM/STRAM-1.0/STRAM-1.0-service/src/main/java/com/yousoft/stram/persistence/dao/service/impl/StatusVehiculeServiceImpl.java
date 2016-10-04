/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.persistence.dao.service.impl;

import com.yousoft.stram.domain.StatusVehicule;
import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.exception.StramException;
import com.yousoft.stram.persistence.dao.StatusVehiculeMapper;
import com.yousoft.stram.persistence.dao.service.StatusVehiculeService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author jguinart
 */

public class StatusVehiculeServiceImpl implements StatusVehiculeService {

    private static final Logger logger = Logger.getLogger(StatusVehiculeServiceImpl.class);

    private static final String NOT_INSERT = "Error, insert status vehicule";

    private static final String NOT_DATA_FOUND = "Error, to search id status vehicule";

    private StatusVehiculeMapper statusVehiculeMapper;

    public void setStatusVehiculeMapper(StatusVehiculeMapper statusVehiculeMapper) {
        this.statusVehiculeMapper = statusVehiculeMapper;
    }

    @Override
    public int insertStatusVehicule(Vehicule vehicule) throws StramException {
        int result = 0;
        try {
            statusVehiculeMapper.insertStatusVehicule(vehicule);
            result = 1;
        } catch (Exception e) {
            logger.error(NOT_INSERT, e);
            throw new StramException(NOT_INSERT, e);
        }
        return result;
    }

    @Override
    public StatusVehicule getStatusById(Vehicule vehicule) throws StramException {
        StatusVehicule statusVehicule = null;
        try {
            statusVehicule = statusVehiculeMapper.findById(vehicule);
            if (statusVehicule != null) {
               vehicule.setStatusVehicule(statusVehicule);
            }

        } catch (Exception e) {
            logger.error(NOT_DATA_FOUND, e);
            throw new StramException(NOT_DATA_FOUND, e);
        }
        return statusVehicule;
    }

}
