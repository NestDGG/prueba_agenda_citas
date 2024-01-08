package com.prueba.prueba.app.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "horario_inicio_consulta", nullable = false)
    private LocalDateTime horarioConsulta;

    @Column(name = "horario_fin_consulta", nullable = false)
    private LocalDateTime horarioFinComsulta;

    @Column(name = "nombre_paciente", nullable = false)
    private String nombrePaciente;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "consultorio_id", referencedColumnName = "id")
    private Consultorio consultorio;

    public Cita() {
        this.horarioFinComsulta = horarioConsulta.plusHours(1);
    }

}
