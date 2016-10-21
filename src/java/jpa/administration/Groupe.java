/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.administration;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author utilisateur
 */
@Entity
public class Groupe implements Serializable {

    @Id
    private String code;
    private String description;
    private boolean useFullAdminReg;
    private boolean useFullAdminOp;
    private boolean useFullSuper = true;
    @OneToMany(mappedBy = "groupe")
    private List<GroupeUtilisateur> groupeUtilisateurs;
    @Version
    private Timestamp version;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GroupeUtilisateur> getGroupeUtilisateurs() {
        return groupeUtilisateurs;
    }

    public void setGroupeUtilisateurs(List<GroupeUtilisateur> groupeUtilisateurs) {
        this.groupeUtilisateurs = groupeUtilisateurs;
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

    public boolean isUseFullAdminReg() {
        return useFullAdminReg;
    }

    public void setUseFullAdminReg(boolean useFullAdminReg) {
        this.useFullAdminReg = useFullAdminReg;
    }

    public boolean isUseFullAdminOp() {
        return useFullAdminOp;
    }

    public void setUseFullAdminOp(boolean useFullAdminOp) {
        this.useFullAdminOp = useFullAdminOp;
    }

    public boolean isUseFullSuper() {
        return useFullSuper;
    }

    public void setUseFullSuper(boolean useFullSuper) {
        this.useFullSuper = useFullSuper;
    }

    @PrePersist
    public void initDateCreation() {
        dateCreation = new Date();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupe)) {
            return false;
        }
        Groupe other = (Groupe) object;
        return !((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code)));
    }
    
    public void reset() {
        this.code = null;
        this.description = null;
        this.useFullAdminOp = false;
        this.useFullAdminReg = false;
        this.useFullSuper = true;
    }
}
