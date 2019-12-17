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
    private String id;
    private String dateAcquisition;
    private String delaiReponse;
    private String delaiResolution;
    private String finGarantie;

    @ManyToOne
    @JoinColumn(name = "idFourniseur")
    private Fournisseur fourniseur;
    @OneToOne
    @JoinColumn(name = "idMateriel")
    private Materiel materiel;

    public Contrat(Fournisseur fourniseur, Materiel materiel){
        this.fourniseur = fourniseur;
        this.materiel = materiel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
