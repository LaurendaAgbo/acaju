/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.administration;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author ohonvoh
 */
@Entity
public class Fonction implements Serializable {
    

    @Id
    private String code;
    private String libelleLong;
    private String libelleCourt;
    private boolean responsabilite = false; //Indique si c'est une fonctionne de responsabilité
    @Version
    private Timestamp version;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fonction)) {
            return false;
        }
        Fonction other = (Fonction) object;
        return !((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code)));
    }

    @PrePersist
    public void prePersist() {
        dateCreation = new Date();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Timestamp getVersion() {
        return version;
    }

    public void setVersion(Timestamp version) {
        this.version = version;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void reset() {
        code = null;
        libelleLong = null;
    }

    public boolean isResponsabilite() {
        return responsabilite;
    }

    public void setResponsabilite(boolean responsabilite) {
        this.responsabilite = responsabilite;
    }

    public String getLibelleLong() {
        /*
        if(libelleLong == null)
            return "-";*/
        return libelleLong;
    }

    public void setLibelleLong(String libelleLong) {
        this.libelleLong = libelleLong;
    }

    public String getLibelleCourt() {
        return libelleCourt;
    }

    public void setLibelleCourt(String libelleCourt) {
        this.libelleCourt = libelleCourt;
    }

}
