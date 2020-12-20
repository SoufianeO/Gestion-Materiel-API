package com.ocp.Model;
import javax.persistence.*;
import java.io.Serializable;

    @Entity
    public class Contrat implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private String idContrat;
    private String dateAcquisition;
    private String delaiReponse;
    private String delaiResolution;
    private String finGarantie;

    @ManyToOne
    @JoinColumn(name = "idFournisseur")
    private Fournisseur fournisseur;
    @OneToOne
    @JoinColumn(name = "idMateriel")
    private Materiel materiel;
    public Contrat(){}
    public Contrat(Fournisseur fournisseur, Materiel materiel){
        this.fournisseur = fournisseur;
        this.materiel = materiel;
    }

    public String getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(String idContrat) {
        this.idContrat = idContrat;
    }

    public String getDateAcquisition() {
        return dateAcquisition;
    }

    public void setDateAcquisition(String dateAcquisition) {
        this.dateAcquisition = dateAcquisition;
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

    public String getDureeGarantie() {
        return finGarantie;
    }

    public void setDureeGarantie(String dureeGarantie) {
        this.finGarantie = dureeGarantie;
    }
}