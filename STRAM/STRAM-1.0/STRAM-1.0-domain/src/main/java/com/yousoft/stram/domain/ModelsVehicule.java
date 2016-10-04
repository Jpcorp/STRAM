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
public class ModelsVehicule implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String name;
    private TypesVehicule typesVehicule;
    private BrandsVehicule brandsVehicule;

    public ModelsVehicule() {
        typesVehicule = new TypesVehicule();
        brandsVehicule = new BrandsVehicule();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the typesVehicule
     */
    public TypesVehicule getTypesVehicule() {
        return typesVehicule;
    }

    /**
     * @param typesVehicule the typesVehicule to set
     */
    public void setTypesVehicule(TypesVehicule typesVehicule) {
        this.typesVehicule = typesVehicule;
    }

    /**
     * @return the brandsVehicule
     */
    public BrandsVehicule getBrandsVehicule() {
        return brandsVehicule;
    }

    /**
     * @param brandsVehicule the brandsVehicule to set
     */
    public void setBrandsVehicule(BrandsVehicule brandsVehicule) {
        this.brandsVehicule = brandsVehicule;
    }
   
}
