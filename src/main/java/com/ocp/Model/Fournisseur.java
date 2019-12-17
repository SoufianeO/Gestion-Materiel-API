package com.ocp.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;

@Entity
@PrimaryKeyJoinColumn(name="matricule")
public class Fournisseur extends Personne implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private String representant;

    public Fournisseur() {
        super();
    }

    @OneToMany(mappedBy = "contrat")

    public String getRepresentant() {
        return representant;
    }

    public void setRepresentant(String representant) {
        this.representant = representant;
    }

}
