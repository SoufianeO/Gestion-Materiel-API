package com.ocp.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
    public class Fournisseur extends Personne implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

        @Id
    private String id;
    private String representant;

    public Fournisseur() {
        super();
    }

    @OneToMany(mappedBy = "fournisseur")
    private List<Contrat> contrats;

    public String getId() {
        return id;
    }
        public void setId(String id) {
            this.id = id;
        }
    public String getRepresentant() {
        return representant;
    }

    public void setRepresentant(String representant) {
        this.representant = representant;
    }

    public List<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }
}