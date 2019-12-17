package com.ocp.Model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@PrimaryKeyJoinColumn(name="matricule")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends AbstractUser implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@ManyToMany
    @JoinTable(name = "lignmateriel",
            joinColumns = {@JoinColumn(name="IdUser")},
            inverseJoinColumns = {@JoinColumn(name="IdMateriel")}
    )
    private List<Materiel> materiel=new ArrayList<Materiel>();

    public User() {
        super();
    }

    public List<Materiel> getMateriel() {
        return materiel;
    }


}
