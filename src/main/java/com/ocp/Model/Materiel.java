package com.ocp.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Materiel implements Serializable {
/**
	 *
	 */
	private static final long serialVersionUID = 1L;
@Id
    private String matricule;
    private String type;
    private String marque;
    private String model;
    private String dateAcquisition;
    private String dateMettreEnService;
    private String etat;

    @OneToOne(mappedBy = "materiel")
    private Contrat contrat;
    @ManyToMany(mappedBy ="materiel" )
    private List<User> users = new ArrayList<>();

    public Materiel(){}

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDateAcquisition() {
        return dateAcquisition;
    }

    public void setDateAcquisition(String dateAcquisition) {
        this.dateAcquisition = dateAcquisition;
    }

    public String getDateMettreEnService() {
        return dateMettreEnService;
    }

    public void setDateMettreEnService(String dateMettreEnService) {
        this.dateMettreEnService = dateMettreEnService;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
