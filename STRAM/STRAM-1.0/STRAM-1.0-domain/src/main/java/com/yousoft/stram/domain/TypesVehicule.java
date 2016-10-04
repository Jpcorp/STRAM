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
 * clase tipo de vehiculos
 * @author jguinart
 */
@ToString
public class TypesVehicule implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String name;
    private Date fechEntry;
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
     * @return the fechEntry
     */
    public Date getFechEntry() {
        return fechEntry;
    }

    /**
     * @param fechEntry the fechEntry to set
     */
    public void setFechEntry(Date fechEntry) {
        this.fechEntry = fechEntry;
    }
    
    
    
}
