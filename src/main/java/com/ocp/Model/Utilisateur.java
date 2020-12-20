package com.ocp.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur extends AbstractUser implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private String idUtilisateur;

    public Utilisateur() {
        super();
    }

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

}
