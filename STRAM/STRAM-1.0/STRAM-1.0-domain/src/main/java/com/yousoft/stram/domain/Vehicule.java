/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.ToString;

/**
 *
 * @author jguinart
 */
@ToString
public class Vehicule implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String patente;
    private ModelsVehicule modelsVehicule;
    private ColorsVehicule colorsVehicule;
    private StatusVehicule statusVehicule;
    private DetailsOwners detailsOwners;
    private String combustible;
    private String nmrMotor;
    private String nmrChasis;
    private String pvr;
    private String nmrPoliza;
    private String venPoliza;
    private String year;

    public Vehicule() {
        this.modelsVehicule = new ModelsVehicule();
        this.colorsVehicule = new ColorsVehicule();
        this.detailsOwners = new DetailsOwners(); 
        this.statusVehicule = new StatusVehicule();
    }

    /**
     * @return the patente
     */
    public String getPatente() {
        return patente;
    }

    /**
     * @param patente the patente to set
     */
    public void setPatente(String patente) {
        this.patente = patente;
    }

    /**
     * @return the modelsVehicule
     */
    public ModelsVehicule getModelsVehicule() {
        return modelsVehicule;
    }

    /**
     * @param modelsVehicule the modelsVehicule to set
     */
    public void setModelsVehicule(ModelsVehicule modelsVehicule) {
        this.modelsVehicule = modelsVehicule;
    }

    /**
     * @return the colorsVehicule
     */
    public ColorsVehicule getColorsVehicule() {
        return colorsVehicule;
    }

    /**
     * @param colorsVehicule the colorsVehicule to set
     */
    public void setColorsVehicule(ColorsVehicule colorsVehicule) {
        this.colorsVehicule = colorsVehicule;
    }

    /**
     * @return the statusVehicule
     */
    public StatusVehicule getStatusVehicule() {
        return statusVehicule;
    }

    /**
     * @param statusVehicule the statusVehicule to set
     */
    public void setStatusVehicule(StatusVehicule statusVehicule) {
        this.statusVehicule = statusVehicule;
    }

    /**
     * @return the detailsOwners
     */
    public DetailsOwners getDetailsOwners() {
        return detailsOwners;
    }

    /**
     * @param detailsOwners the detailsOwners to set
     */
    public void setDetailsOwners(DetailsOwners detailsOwners) {
        this.detailsOwners = detailsOwners;
    }

    /**
     * @return the combustible
     */
    public String getCombustible() {
        return combustible;
    }

    /**
     * @param combustible the combustible to set
     */
    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    /**
     * @return the nmrMotor
     */
    public String getNmrMotor() {
        return nmrMotor;
    }

    /**
     * @param nmrMotor the nmrMotor to set
     */
    public void setNmrMotor(String nmrMotor) {
        this.nmrMotor = nmrMotor;
    }

    /**
     * @return the nmrChasis
     */
    public String getNmrChasis() {
        return nmrChasis;
    }

    /**
     * @param nmrChasis the nmrChasis to set
     */
    public void setNmrChasis(String nmrChasis) {
        this.nmrChasis = nmrChasis;
    }

    /**
     * @return the pvr
     */
    public String getPvr() {
        return pvr;
    }

    /**
     * @param pvr the pvr to set
     */
    public void setPvr(String pvr) {
        this.pvr = pvr;
    }

    /**
     * @return the nmrPoliza
     */
    public String getNmrPoliza() {
        return nmrPoliza;
    }

    /**
     * @param nmrPoliza the nmrPoliza to set
     */
    public void setNmrPoliza(String nmrPoliza) {
        this.nmrPoliza = nmrPoliza;
    }

    /**
     * @return the venPoliza
     */
    public String getVenPoliza() {
        return venPoliza;
    }

    /**
     * @param venPoliza the venPoliza to set
     */
    public void setVenPoliza(String venPoliza) {
        this.venPoliza = venPoliza;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }
    
    
    
}
