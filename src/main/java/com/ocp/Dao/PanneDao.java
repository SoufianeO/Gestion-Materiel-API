package com.ocp.Dao;

import com.ocp.Model.Panne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanneDao extends JpaRepository<Panne, String> {
}
