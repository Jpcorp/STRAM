/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.persistence.dao.service.impl;

import com.yousoft.stram.domain.BrandsVehicule;
import com.yousoft.stram.domain.ModelsVehicule;
import com.yousoft.stram.domain.TypesVehicule;
import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.exception.StramException;
import com.yousoft.stram.persistence.dao.ModelsVehiculeMapper;
import com.yousoft.stram.persistence.dao.service.ModelsVehiculeService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author jguinart
 */
public class ModelsVehiculeServiceImpl implements ModelsVehiculeService {

    private static final Logger logger = Logger.getLogger(ModelsVehiculeServiceImpl.class);

    private static final String NOT_INSERT = "Error, insert models vehicule";

    private static final String NOT_DATA_FOUND = "Error, to search models vehicule";

    private ModelsVehiculeMapper modelsVehiculeMapper;

    public void setModelsVehiculeMapper(ModelsVehiculeMapper modelsVehiculeMapper) {
        this.modelsVehiculeMapper = modelsVehiculeMapper;
    }

    @Override
    public int insertModelsVehicule(Vehicule vehicule) throws StramException {
        int result = 0;
        try {
            modelsVehiculeMapper.insertModelsVehicule(vehicule);
            result = 1;
        } catch (Exception e) {
            logger.error(NOT_INSERT, e);
            throw new StramException(NOT_INSERT, e);
        }
        return result;
    }

    @Override
    public ModelsVehicule getModelsVehiculeByName(Vehicule vehicule) throws StramException {
        ModelsVehicule modelsVehicule = null;
        String name = vehicule.getModelsVehicule().getName();
        try {
            if (vehicule.getModelsVehicule().getName() != null
                    && !vehicule.getModelsVehicule().getName().isEmpty()) {

                String bn = "%" + vehicule.getModelsVehicule().getName() + "%";
                vehicule.getModelsVehicule().setName(bn);
            }
            modelsVehicule = modelsVehiculeMapper.findByName(vehicule);
           vehicule.getModelsVehicule().setName(name);
            if (modelsVehicule != null) {
                TypesVehicule types = vehicule.getModelsVehicule().getTypesVehicule();
                BrandsVehicule brands = vehicule.getModelsVehicule().getBrandsVehicule();
                modelsVehicule.setTypesVehicule(types);
                modelsVehicule.setBrandsVehicule(brands);
                vehicule.setModelsVehicule(modelsVehicule);
            }

        } catch (Exception e) {
            logger.error(NOT_DATA_FOUND, e);
            throw new StramException(NOT_DATA_FOUND, e);
        }
        return modelsVehicule;
    }

}
