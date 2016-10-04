/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.domain;

import java.io.Serializable;
import lombok.ToString;

/**
 *
 * @author jguinart
 */
@ToString
public class OwnersVehicule implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String run;
    private String name;
    private String phone;
    private String tlfHouse;
    private String comuna;
    private String direccion;
    private int nmroDireccion;
    private String region;

    /**
     * @return the run
     */
    public String getRun() {
        return run;
    }

    /**
     * @param run the run to set
     */
    public void setRun(String run) {
        this.run = run;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the tlfHouse
     */
    public String getTlfHouse() {
        return tlfHouse;
    }

    /**
     * @param tlfHouse the tlfHouse to set
     */
    public void setTlfHouse(String tlfHouse) {
        this.tlfHouse = tlfHouse;
    }

    /**
     * @return the comuna
     */
    public String getComuna() {
        return comuna;
    }

    /**
     * @param comuna the comuna to set
     */
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the nmroDireccion
     */
    public int getNmroDireccion() {
        return nmroDireccion;
    }

    /**
     * @param nmroDireccion the nmroDireccion to set
     */
    public void setNmroDireccion(int nmroDireccion) {
        this.nmroDireccion = nmroDireccion;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }
    
    
    
    
}
