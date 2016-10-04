/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.service.beans.service.impl;

import java.text.ParseException;
import java.util.regex.Matcher;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.yousoft.stram.domain.BrandsVehicule;
import com.yousoft.stram.domain.ColorsVehicule;
import com.yousoft.stram.domain.DetailsOwners;
import com.yousoft.stram.domain.OwnersVehicule;
import com.yousoft.stram.domain.StatusVehicule;
import com.yousoft.stram.domain.TypesVehicule;
import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.exception.StramException;
import com.yousoft.stram.service.beans.service.ManagerDocumentVehiculeService;
import com.yousoft.stram.service.beans.service.ManagerParserDocumentService;
import com.yousoft.stram.service.utils.ApplicationUtils;
import com.yousoft.stram.service.utils.PatternUtils;

/**
 *
 * @author jguinart
 */
public class ManagerParserDocumentServiceImpl implements ManagerParserDocumentService {

    private static final Logger logger = Logger.getLogger(ManagerParserDocumentServiceImpl.class);

    @Value("${parser.document.expression.regular}")
    private String regular;

    @Value("${parser.document.expression.not.parse.found}")
    private String NOT_PARSE_FOUND;
    
    @Autowired
    private ManagerDocumentVehiculeService managerProcessDocument;
      
    private final int ID = 1;
    
    private final String FIRST_STATUS = "INGRESADO_STRAM";
    
    private final String ERROR_NO_PARSE_DATE = "ERROR, can't change format date ";

    @Override
    public void processDocumentCav(StringBuffer input) {
        logger.debug("Process input :" + input.toString());
        try {
            Vehicule vehicule = getParseDocument(input);
            if (vehicule != null) {
                changeFormatDate(vehicule);
                managerProcessDocument.saveDocument(vehicule);
            }
        } catch (StramException e) {
            logger.error("Error process CAV : ", e);
        }

    }
    
    @Override
    public Vehicule getParseDocument(StringBuffer input) throws StramException {
        Vehicule result = null;
        if ("".equals(input.toString())) {
            throw new StramException("Error, expresion regular not define");
        }
        final Matcher mat = PatternUtils.getPatternWithAll(input.toString(), regular);

        try {
            if (mat.find()) {
                result = new Vehicule();
                result.setPatente(mat.group(1).trim());
                setTypeVehicule(mat, result);
                result.setYear(mat.group(3).trim());
                setBrandVehicule(mat, result);
                result.getModelsVehicule().setName(mat.group(5).trim());
                result.setNmrMotor(mat.group(6).trim());
                result.setNmrChasis(mat.group(7).trim());
                result.setCombustible(mat.group(9).trim());
                result.setPvr(mat.group(10).trim());
                result.setNmrPoliza(mat.group(12).trim());
                result.setVenPoliza(mat.group(13).trim());
                setColorsVehiculeId(mat, result);
                setDetailsOwnersVehicule(mat, result);
                setOwnersVehicule(mat, result);
                setStatusVehicule(result);   
            } 
        } catch (Exception e) {
            throw new StramException(NOT_PARSE_FOUND, e);
        }

        return result;
    }

    private void setTypeVehicule(Matcher mat, Vehicule result) {
        TypesVehicule typesVehicule = new TypesVehicule();
        typesVehicule.setName(mat.group(2).trim());
        result.getModelsVehicule().setTypesVehicule(typesVehicule);
    }

    private void setBrandVehicule(Matcher mat, Vehicule result) {
        BrandsVehicule brandsVehicule = new BrandsVehicule();
        brandsVehicule.setName(mat.group(4).trim());
        result.getModelsVehicule().setBrandsVehicule(brandsVehicule);
    }

    private void setOwnersVehicule(Matcher mat, Vehicule result) {
        OwnersVehicule ownersVehicule = new OwnersVehicule();
        ownersVehicule.setName(mat.group(14).trim());
        ownersVehicule.setRun(mat.group(15).trim());
        result.getDetailsOwners().setOwnersVehicule(ownersVehicule);
    }

    private void setColorsVehiculeId(Matcher mat, Vehicule result) {
        ColorsVehicule colorsVehicule = new ColorsVehicule();
        colorsVehicule.setName(mat.group(8).trim());
        result.setColorsVehicule(colorsVehicule);
    }

    private void setDetailsOwnersVehicule(Matcher mat, Vehicule result) throws ParseException {
        DetailsOwners details = new DetailsOwners();
        details.setCdgPatente(result.getPatente());
        details.setFechAdquisicion(ApplicationUtils.convertToDate(mat.group(16).trim()));
        details.setRepertorio(mat.group(17).trim());
        result.setDetailsOwners(details);
    }

    private void setStatusVehicule(Vehicule result) {
        StatusVehicule status = new StatusVehicule();
        status.setId(ID);
        status.setName(FIRST_STATUS);
        result.setStatusVehicule(status);
    }

    /**
     * @param managerProcessDocument the managerProcessDocument to set
     */
    public void setManagerProcessDocument(ManagerDocumentVehiculeService managerProcessDocument) {
        this.managerProcessDocument = managerProcessDocument;
    }

    private void changeFormatDate(Vehicule vehicule) {
        try {
            String date = ApplicationUtils.changeFormatDate(vehicule.getVenPoliza());
            vehicule.setVenPoliza(date);
        } catch (ParseException ex) {
           logger.error(ERROR_NO_PARSE_DATE, ex);
        }
        
    }
    
    

}
