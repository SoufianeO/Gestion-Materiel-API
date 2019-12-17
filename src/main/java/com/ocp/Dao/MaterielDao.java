package com.ocp.Dao;

import com.ocp.Model.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterielDao extends JpaRepository<Materiel, String> {
}
