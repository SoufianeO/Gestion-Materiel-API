package com.ocp.Dao;

import com.ocp.Model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratDao extends JpaRepository<Contrat,String> {
}
