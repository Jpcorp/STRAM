/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.persistence.dao.service.impl;

import org.apache.log4j.Logger;

import com.yousoft.stram.domain.TypesVehicule;
import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.exception.StramException;
import com.yousoft.stram.persistence.dao.TypesVehiculeMapper;
import com.yousoft.stram.persistence.dao.service.TypesVehiculeService;

/**
 *
 * @author jguinart
 */
public class TypesVehiculeServiceImpl implements TypesVehiculeService {

    private static final Logger logger = Logger.getLogger(TypesVehiculeServiceImpl.class);

    private static final String NOT_INSERT = "Error, insert types vehicule";
    
    private static final String NOT_DATA_FOUND = "Error, to search types vehicule";

    private TypesVehiculeMapper typesVehiculeMapper;

    public void setTypesVehiculeMapper(TypesVehiculeMapper typesVehiculeMapper) {
        this.typesVehiculeMapper = typesVehiculeMapper;
    }

    @Override
    public int inserTypesVehicule(Vehicule vehicule) throws StramException {
        int result = 0;
        try {
            typesVehiculeMapper.insertTypesVehicule(vehicule);
        } catch (Exception e) {
            logger.error(NOT_INSERT, e);
            throw new StramException(NOT_INSERT, e);
        }
        return result;
    }

    @Override
    public TypesVehicule getTypesVehiculeByName(Vehicule vehicule) throws StramException {
        TypesVehicule typesVehicule = null;
        String name = vehicule.getModelsVehicule().getTypesVehicule().getName();
        try {
            if (vehicule.getModelsVehicule().getTypesVehicule().getName() != null 
                    && !vehicule.getModelsVehicule().getTypesVehicule().getName().isEmpty()) {
                
                String bn = "%" + vehicule.getModelsVehicule().getTypesVehicule().getName() + "%";
                vehicule.getModelsVehicule().getTypesVehicule().setName(bn);
            }
            typesVehicule = typesVehiculeMapper.findByName(vehicule);
            vehicule.getModelsVehicule().getTypesVehicule().setName(name);
            if (typesVehicule != null) {
                vehicule.getModelsVehicule().setTypesVehicule(typesVehicule);
            }
            
        } catch (Exception e) {
            logger.error(NOT_DATA_FOUND, e);
            throw new StramException(NOT_DATA_FOUND, e);
        }
        return typesVehicule;
    }

}
