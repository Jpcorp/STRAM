/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.service.beans.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.yousoft.stram.domain.BrandsVehicule;
import com.yousoft.stram.domain.ColorsVehicule;
import com.yousoft.stram.domain.DetailsOwners;
import com.yousoft.stram.domain.ModelsVehicule;
import com.yousoft.stram.domain.OwnersVehicule;
import com.yousoft.stram.domain.StatusVehicule;
import com.yousoft.stram.domain.TypesVehicule;
import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.exception.StramException;
import com.yousoft.stram.persistence.dao.service.BrandsVehiculeService;
import com.yousoft.stram.persistence.dao.service.ColorsVehiculeService;
import com.yousoft.stram.persistence.dao.service.DetailsOwnersVehiculeService;
import com.yousoft.stram.persistence.dao.service.ModelsVehiculeService;
import com.yousoft.stram.persistence.dao.service.OwnersVehiculeService;
import com.yousoft.stram.persistence.dao.service.StatusVehiculeService;
import com.yousoft.stram.persistence.dao.service.TypesVehiculeService;
import com.yousoft.stram.persistence.dao.service.VehiculeService;
import com.yousoft.stram.service.beans.service.ManagerDocumentVehiculeService;
import com.yousoft.stram.service.utils.ManagerDocument;

/**
 *
 * @author jguinart
 */
//@Component(value="managerDocumentVehiculeService") //ponle nu nombre aca, para q sepa q bean inyectar, tu le esras hhaciendo referecnia a la interfaz, por eso no caccha cual inyectar
public class ManagerDocumentVehiculeServiceImpl extends ManagerDocument implements ManagerDocumentVehiculeService {

    private static final Logger logger = Logger.getLogger(ManagerParserDocumentServiceImpl.class);

    @Autowired
    private BrandsVehiculeService brandsVehiculeService;
    
    @Autowired
    private ColorsVehiculeService colorsVehiculeService;
    
    @Autowired
    private DetailsOwnersVehiculeService detailsOwnersVehiculeService;
       
    @Autowired
    private ModelsVehiculeService modelsVehiculeService;
    
    @Autowired
    private OwnersVehiculeService ownersVehiculeService;
    
    @Autowired
    private TypesVehiculeService typeVehiculeService;
    
    @Autowired
    private StatusVehiculeService statusVehiculeService;
    
    @Autowired 
    private VehiculeService vehiculeService;

    private final String NOT_SAVE_VEHICULE = "ERROR, can't save vehicule";

    @Override
    public void saveDocument(Vehicule vehicule) throws StramException {
        try {
            saveBrandsVehicule(vehicule);
            saveTypesVehicule(vehicule);
            saveModelsVehicule(vehicule);
            saveColorVehicule(vehicule);
            saveStatusVehicule(vehicule);
            saveVehicule(vehicule);
            saveOwners(vehicule);
            saveDetailsOwners(vehicule);
        } catch (Exception e) {
            logger.error(NOT_SAVE_VEHICULE, e);
            throw new StramException(NOT_SAVE_VEHICULE, e);
        }
    }

    private void saveBrandsVehicule(Vehicule vehicule) throws StramException {
        BrandsVehicule brandsVehicule = brandsVehiculeService.getBrandsVehiculeByName(vehicule);
        if (brandsVehicule == null) {
            brandsVehiculeService.insertBrandsVehicule(vehicule);
            brandsVehiculeService.getBrandsVehiculeByName(vehicule);
        }
    }

    private void saveTypesVehicule(Vehicule vehicule) throws StramException {
        TypesVehicule typesVehicule = typeVehiculeService.getTypesVehiculeByName(vehicule);
        if (typesVehicule == null) {
            typeVehiculeService.inserTypesVehicule(vehicule);
            typeVehiculeService.getTypesVehiculeByName(vehicule);
        }
        
    }
    private void saveModelsVehicule(Vehicule vehicule) throws StramException {
        ModelsVehicule modelsVehicule = modelsVehiculeService.getModelsVehiculeByName(vehicule);
        if (modelsVehicule == null) {
            modelsVehiculeService.insertModelsVehicule(vehicule);
            modelsVehiculeService.getModelsVehiculeByName(vehicule);
        }
        
    }

    private void saveColorVehicule(Vehicule vehicule) throws StramException {
        ColorsVehicule colorsVehicule = colorsVehiculeService.getColorsVehiculeByName(vehicule);
        if (colorsVehicule == null) {
            colorsVehiculeService.insertColorsVehicule(vehicule);
            colorsVehiculeService.getColorsVehiculeByName(vehicule);
        }
    }

    private void saveStatusVehicule(Vehicule vehicule) throws StramException {
        StatusVehicule result = statusVehiculeService.getStatusById(vehicule);
        if (result == null) {
            StatusVehicule statusVehicule = new StatusVehicule();
            statusVehicule.setId(STATUS_INITIAL_VEHICULE);
            statusVehicule.setName(STATUS_DSC_INITIAL_VEHICULE);
            vehicule.setStatusVehicule(statusVehicule);
            statusVehiculeService.insertStatusVehicule(vehicule);
        }
    }

    private void saveVehicule(Vehicule vehicule) throws StramException {
        Vehicule result = vehiculeService.getVehiculePatente(vehicule);
        if (result == null) {
            vehiculeService.insertBrandsVehicule(vehicule);
        }
    }

    private void saveDetailsOwners(Vehicule vehicule) throws StramException {
        DetailsOwners detailsOwners = detailsOwnersVehiculeService.findByRun(vehicule);
        if (detailsOwners == null) {
            detailsOwnersVehiculeService.insertOwnersVehicule(vehicule);
        }
                
    }

    private void saveOwners(Vehicule vehicule) throws StramException {
        OwnersVehicule ownersVehicule = ownersVehiculeService.getOwnersVehiculeByRun(vehicule);
        if (ownersVehicule == null) {
            ownersVehiculeService.insertOwnersVehicule(vehicule);
            ownersVehiculeService.getOwnersVehiculeByRun(vehicule);
        }
    }

    /**
     * @param brandsVehiculeService the brandsVehiculeService to set
     */
    public void setBrandsVehiculeService(BrandsVehiculeService brandsVehiculeService) {
        this.brandsVehiculeService = brandsVehiculeService;
    }

    /**
     * @param colorsVehiculeService the colorsVehiculeService to set
     */
    public void setColorsVehiculeService(ColorsVehiculeService colorsVehiculeService) {
        this.colorsVehiculeService = colorsVehiculeService;
    }

    /**
     * @param detailsOwnersVehiculeService the detailsOwnersVehiculeService to set
     */
    public void setDetailsOwnersVehiculeService(DetailsOwnersVehiculeService detailsOwnersVehiculeService) {
        this.detailsOwnersVehiculeService = detailsOwnersVehiculeService;
    }

    /**
     * @param modelsVehiculeService the modelsVehiculeService to set
     */
    public void setModelsVehiculeService(ModelsVehiculeService modelsVehiculeService) {
        this.modelsVehiculeService = modelsVehiculeService;
    }

    /**
     * @param ownersVehiculeService the ownersVehiculeService to set
     */
    public void setOwnersVehiculeService(OwnersVehiculeService ownersVehiculeService) {
        this.ownersVehiculeService = ownersVehiculeService;
    }

    /**
     * @param typeVehiculeService the typeVehiculeService to set
     */
    public void setTypeVehiculeService(TypesVehiculeService typeVehiculeService) {
        this.typeVehiculeService = typeVehiculeService;
    }

    /**
     * @param statusVehiculeService the statusVehiculeService to set
     */
    public void setStatusVehiculeService(StatusVehiculeService statusVehiculeService) {
        this.statusVehiculeService = statusVehiculeService;
    }

    /**
     * @param vehiculeService the vehiculeService to set
     */
    public void setVehiculeService(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }
    
    

}
