package com.ocp.Dao;

import com.ocp.Model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurDao extends JpaRepository<Fournisseur,String> {
}
