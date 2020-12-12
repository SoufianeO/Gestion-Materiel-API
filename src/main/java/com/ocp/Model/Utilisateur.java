package com.ocp.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur extends AbstractUser implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    public Utilisateur() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
