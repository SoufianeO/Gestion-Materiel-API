package com.ocp.Model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
    @Inheritance(strategy = InheritanceType.JOINED)
    public class Fonctionnaire extends AbstractUser implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private String idFonctionnaire;
    @NotBlank(message = "Login")
    private String login;
    @NotBlank(message = "Mot de passe")
    private String motPasse;
    @NotBlank(message = "Role")
    private String role;
    @OneToMany(mappedBy="fonctionnaire")
    private List<Panne> pannes;

    public Fonctionnaire() {
        super();
    }

    public String getIdFonctionnaire() {
        return idFonctionnaire;
    }

    public void setIdFonctionnaire(String idFonctionnaire) {
        this.idFonctionnaire = idFonctionnaire;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Panne> getPannes() {
        return pannes;
    }

    public void setPannes(List<Panne> pannes) {
        this.pannes = pannes;
    }
}