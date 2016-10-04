/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousoft.stram.persistence.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jguinart
 */
@Entity
@Table(name = "colors_vehicule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ColorsVehicule.findAll", query = "SELECT c FROM ColorsVehicule c"),
    @NamedQuery(name = "ColorsVehicule.findByClsvehCdgId", query = "SELECT c FROM ColorsVehicule c WHERE c.clsvehCdgId = :clsvehCdgId"),
    @NamedQuery(name = "ColorsVehicule.findByClsvehNmbName", query = "SELECT c FROM ColorsVehicule c WHERE c.clsvehNmbName = :clsvehNmbName")})
public class ColorsVehicule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLSVEH_CDG_ID")
    private Integer clsvehCdgId;
    @Size(max = 30)
    @Column(name = "CLSVEH_NMB_NAME")
    private String clsvehNmbName;

    public ColorsVehicule() {
    }

    public ColorsVehicule(Integer clsvehCdgId) {
        this.clsvehCdgId = clsvehCdgId;
    }

    public Integer getClsvehCdgId() {
        return clsvehCdgId;
    }

    public void setClsvehCdgId(Integer clsvehCdgId) {
        this.clsvehCdgId = clsvehCdgId;
    }

    public String getClsvehNmbName() {
        return clsvehNmbName;
    }

    public void setClsvehNmbName(String clsvehNmbName) {
        this.clsvehNmbName = clsvehNmbName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clsvehCdgId != null ? clsvehCdgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColorsVehicule)) {
            return false;
        }
        ColorsVehicule other = (ColorsVehicule) object;
        if ((this.clsvehCdgId == null && other.clsvehCdgId != null) || (this.clsvehCdgId != null && !this.clsvehCdgId.equals(other.clsvehCdgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yousoft.stram.persistence.dao.ColorsVehicule[ clsvehCdgId=" + clsvehCdgId + " ]";
    }
    
}
