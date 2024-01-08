package com.prueba.prueba.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "consultorio")
public class Consultorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_consultorio", nullable = false)
    private Integer numeroConsultorio;

    @Column(name = "piso", nullable = false)
    private Integer piso;

}
