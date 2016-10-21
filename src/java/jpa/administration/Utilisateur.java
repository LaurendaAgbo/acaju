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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Utilisateur implements Serializable {
    
    @Id
    private String login;
    private String nom;
    private String prenom;
    private String mail;
    private String boitePostale;
    private String password;
    private String telephone;
    private String sessionId;
    private int connectionStatus = -1; //-1 - jamais connecté, 0 - déconnecté, 1 - connecté actif, 3 - connecté inactif
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date logoutTime;
    
    @Enumerated(EnumType.STRING)
    private EnumGenre genre;
    
    @Version
    private Timestamp version;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @OneToMany(mappedBy = "utilisateur")
    private List<GroupeUtilisateur> groupeUtilisateurs;

    public Utilisateur() {
        genre = EnumGenre.M;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getBoitePostale() {
        return boitePostale;
    }

    public void setBoitePostale(String boitePostale) {
        this.boitePostale = boitePostale;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    
    @PrePersist
    public void initDateCreation() {
        dateCreation = new Date();
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        return !((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login)));
    }
    
    public EnumGenre getGenre() {
        return genre;
    }

    public void setGenre(EnumGenre genre) {
        this.genre = genre;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public void reset() {
        this.login = null;
        this.password = null;
        this.nom = null;
        this.prenom = null;
        this.genre = null;
        this.boitePostale = null;
        this.mail = null;
        this.telephone = null;
    }


    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public int getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(int connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public List<GroupeUtilisateur> getGroupeUtilisateurs() {
        return groupeUtilisateurs;
    }

    public void setGroupeUtilisateurs(List<GroupeUtilisateur> groupeUtilisateurs) {
        this.groupeUtilisateurs = groupeUtilisateurs;
    }
    
}
