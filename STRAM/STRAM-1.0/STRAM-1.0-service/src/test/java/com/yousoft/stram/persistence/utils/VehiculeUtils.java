/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.persistence.utils;

import com.yousoft.stram.domain.BrandsVehicule;
import com.yousoft.stram.domain.ColorsVehicule;
import com.yousoft.stram.domain.DetailsOwners;
import com.yousoft.stram.domain.ModelsVehicule;
import com.yousoft.stram.domain.OwnersVehicule;
import com.yousoft.stram.domain.StatusVehicule;
import com.yousoft.stram.domain.TypesVehicule;
import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.service.utils.ApplicationUtils;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author jguinart
 */
public class VehiculeUtils {

    private Vehicule vehicule;

    public VehiculeUtils() {
        setVehiculeTest();
    }

    private void setVehiculeTest() {

        setVehicule(new Vehicule());
        getVehicule().setPatente("DX.CH.94");
        getVehicule().setCombustible("Bencina");
        getVehicule().setNmrMotor("12345689");
        getVehicule().setNmrChasis("KHG1234567");
        getVehicule().setPvr("PVR");
        getVehicule().setNmrPoliza("ASDF1782G");
        getVehicule().setVenPoliza("2006-01-01");
        getVehicule().setYear("2013");
        getVehicule().setModelsVehicule(createBrandsTypesModelsVehicule());
        getVehicule().setColorsVehicule(createColorVehicule());
        getVehicule().setStatusVehicule(createStatusVehicule());
        getVehicule().setDetailsOwners(createOwnerDetailsVehicule());

    }

    private ModelsVehicule createBrandsTypesModelsVehicule() {
        BrandsVehicule brandsVehicule = new BrandsVehicule();
        brandsVehicule.setName("KIA MOTORS");
        brandsVehicule.setId(1);

        TypesVehicule type = new TypesVehicule();
        type.setFechEntry(new Date());
        type.setId(1);
        type.setName("AUTOMOVIL");

        ModelsVehicule modelsVehicule = new ModelsVehicule();
        modelsVehicule.setName("RIO 5");
        modelsVehicule.setId(1);
        modelsVehicule.setTypesVehicule(type);
        modelsVehicule.setBrandsVehicule(brandsVehicule);
        return modelsVehicule;
    }

    private ColorsVehicule createColorVehicule() {
        ColorsVehicule colorsVehicule = new ColorsVehicule();
        colorsVehicule.setName("AZUL SANTORINI");
        colorsVehicule.setId(1);
        return colorsVehicule;

    }

    private StatusVehicule createStatusVehicule() {
        StatusVehicule statusVehicule = new StatusVehicule();
        statusVehicule.setName("INGRESADO_STRAM");
        statusVehicule.setId(1);
        return statusVehicule;
    }

    private DetailsOwners createOwnerDetailsVehicule() {
        DetailsOwners detailsOwners = new DetailsOwners();
        detailsOwners.setCdgPatente(getVehicule().getPatente());
        detailsOwners.setFechAdquisicion(new Date());
        detailsOwners.setNmro(12345);
        detailsOwners.setRepertorio("K5PFGJ");
        OwnersVehicule owner = new OwnersVehicule();
        owner.setRun("16743635-8");
        detailsOwners.setOwnersVehicule(owner);
        return detailsOwners;
    }

    /**
     * @return the vehicule
     */
    public Vehicule getVehicule() {
        return vehicule;
    }

    /**
     * @param vehicule the vehicule to set
     */
    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

}
