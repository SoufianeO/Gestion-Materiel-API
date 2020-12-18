package com.ocp.Model;
import javax.persistence.*;
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
    private String delaiReponse;
    private String delaiResolution;
    private String description;
    private String etat;

    @ManyToOne
    @JoinColumn(name = "id_materiel")
    private Materiel materiel;
    @ManyToOne
    @JoinColumn(name = "id_fonctionnaire")
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

    public String getDelaiReponse() {
            return delaiReponse;
        }

        public void setDelaiReponse(String delaiReponse) {
            this.delaiReponse = delaiReponse;
        }

    public String getDelaiResolution() {
        return delaiResolution;
    }

    public void setDelaiResolution(String delaiResolution) {
        this.delaiResolution = delaiResolution;
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