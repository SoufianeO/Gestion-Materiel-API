package com.ocp.Model;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

    @MappedSuperclass
    @Inheritance(strategy = InheritanceType.JOINED)
    public abstract class AbstractUser extends Personne {

    private String matricule;
    private String service;
    private String site;

    protected AbstractUser(){}

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

}