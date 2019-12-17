package com.ocp.Dao;

import com.ocp.Model.Fonctionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FontionnaireDao extends JpaRepository<Fonctionnaire, String> {
}
