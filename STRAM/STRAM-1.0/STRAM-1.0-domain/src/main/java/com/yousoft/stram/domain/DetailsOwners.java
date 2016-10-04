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
public class DetailsOwners implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String cdgPatente;
    private OwnersVehicule ownersVehicule;
    private Date fechAdquisicion;
    private String repertorio;
    private int nmro;

    public DetailsOwners() {
        ownersVehicule = new OwnersVehicule();
    }

    /**
     * @return the ownersVehicule
     */
    public OwnersVehicule getOwnersVehicule() {
        return ownersVehicule;
    }

    /**
     * @param ownersVehicule the ownersVehicule to set
     */
    public void setOwnersVehicule(OwnersVehicule ownersVehicule) {
        this.ownersVehicule = ownersVehicule;
    }

    /**
     * @return the fechAdquisicion
     */
    public Date getFechAdquisicion() {
        return fechAdquisicion;
    }

    /**
     * @param fechAdquisicion the fechAdquisicion to set
     */
    public void setFechAdquisicion(Date fechAdquisicion) {
        this.fechAdquisicion = fechAdquisicion;
    }

    /**
     * @return the repertorio
     */
    public String getRepertorio() {
        return repertorio;
    }

    /**
     * @param repertorio the repertorio to set
     */
    public void setRepertorio(String repertorio) {
        this.repertorio = repertorio;
    }

    /**
     * @return the nmro
     */
    public int getNmro() {
        return nmro;
    }

    /**
     * @param nmro the nmro to set
     */
    public void setNmro(int nmro) {
        this.nmro = nmro;
    }

    /**
     * @return the cdgPatente
     */
    public String getCdgPatente() {
        return cdgPatente;
    }

    /**
     * @param cdgPatente the cdgPatente to set
     */
    public void setCdgPatente(String cdgPatente) {
        this.cdgPatente = cdgPatente;
    }
    
    

    
    
}
