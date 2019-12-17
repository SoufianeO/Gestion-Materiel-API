package com.ocp.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Panne implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private String numeroDemande;
    private String dateDeclaration;
    private String dateResolution;
    private String description;
    private String etat;

    @ManyToOne
    @JoinColumn(name = "materiel")
    private Materiel Materiel;
    @ManyToOne
    @JoinColumn(name = "fonctionnaire")
    private Fonctionnaire fonctionnaire;

    public Panne(){}

    public String getNumeroDemande() {
        return numeroDemande;
    }

    public void setNumeroDemande(String numeroDemande) {
        this.numeroDemande = numeroDemande;
    }

    public String getDateDeclaration() {
        return dateDeclaration;
    }

    public void setDateDeclaration(String dateDeclaration) {
        this.dateDeclaration = dateDeclaration;
    }

    public String getDateResolution() {
        return dateResolution;
    }

    public void setDateResolution(String dateResolution) {
        this.dateResolution = dateResolution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}