package com.prueba.prueba.app.repository;

import com.prueba.prueba.app.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CitasRepository extends JpaRepository<Cita, Long> {

    boolean existsByConsultorio_IdAndHorarioConsulta(Long id, LocalDateTime horarioConsulta);

    long countByDoctor_Id(Long id);

    boolean existsByDoctor_IdAndHorarioConsulta(Long id, LocalDateTime horarioConsulta);

    Cita findFirstByNombrePacienteOrderByHorarioFinComsultaDesc(String nombrePaciente);

    List<Cita> findByHorarioConsultaAndDoctor_IdAndConsultorio_Id(LocalDateTime horarioConsulta, Long idDoctor, Long idConsultorio);











}
