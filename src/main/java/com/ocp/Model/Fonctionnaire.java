package com.ocp.Model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@PrimaryKeyJoinColumn(name="matricule")
@Inheritance(strategy = InheritanceType.JOINED)
public class Fonctionnaire extends AbstractUser implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @NotBlank(message = "Login")
    private String login;
    @NotBlank(message = "Mot de passe")
    private String motPasse;
    @NotBlank(message = "Role")
    private String role;

    public Fonctionnaire() {
        super();
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
}
