package com.prueba.prueba.app.repository;

import com.prueba.prueba.app.entity.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultoriosRepository extends JpaRepository<Consultorio, Long> {



}
