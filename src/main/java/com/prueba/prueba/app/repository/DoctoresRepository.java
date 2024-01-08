package com.prueba.prueba.app.repository;


import com.prueba.prueba.app.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctoresRepository extends JpaRepository<Doctor, Long> {
}
