/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.persistence.dao.service.impl;

import com.yousoft.stram.domain.ColorsVehicule;
import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.exception.StramException;
import com.yousoft.stram.persistence.dao.ColorsVehiculeMapper;
import com.yousoft.stram.persistence.dao.service.ColorsVehiculeService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author jguinart
 */
public class ColorsVehiculeServiceImpl implements ColorsVehiculeService {
    
    private static final Logger logger = Logger.getLogger(ColorsVehiculeServiceImpl.class);
    
    private static final String NOT_INSERT = "Error, insert colors vehicule";
    
    private static final String NOT_DATA_FOUND = "Error, to search colors vehicule";
    
    private ColorsVehiculeMapper colorsVehiculeMapper;
    
    public void setColorsVehiculeMapper(ColorsVehiculeMapper colorsVehiculeMapper) {
        this.colorsVehiculeMapper = colorsVehiculeMapper;
    }
    
    @Override
    public int insertColorsVehicule(Vehicule vehicule) throws StramException {
        int result = 0;
        try {
            colorsVehiculeMapper.insertColorsVehicule(vehicule);
            result = 1;
        } catch (Exception e) {
            logger.error(NOT_INSERT, e);
            throw new StramException(NOT_INSERT, e);
        }
        return result;
    }
    
    @Override
    public ColorsVehicule getColorsVehiculeByName(Vehicule vehicule) throws StramException {
        ColorsVehicule colorsVehicule = null;
        String name = vehicule.getColorsVehicule().getName();
        try {
            if (vehicule.getColorsVehicule().getName() != null
                    && !vehicule.getColorsVehicule().getName().isEmpty()) {
                
                String bn = "%" + vehicule.getColorsVehicule().getName() + "%";
                vehicule.getColorsVehicule().setName(bn);
            }
            colorsVehicule = colorsVehiculeMapper.findByName(vehicule);
            vehicule.getColorsVehicule().setName(name);
            if (colorsVehicule != null) {
                vehicule.setColorsVehicule(colorsVehicule);
            }
        } catch (Exception e) {
            logger.error(NOT_DATA_FOUND, e);
            throw new StramException(NOT_DATA_FOUND, e);
        }
        return colorsVehicule;
    }
    
}
