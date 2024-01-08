package com.prueba.prueba.app.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres", length = 100, nullable = false)
    private String nombre;
    @Column(name = "apellido_paterno", length = 100, nullable = false)
    private String apellidoPaterno;
    @Column(name = "apellido_maternos", length = 100, nullable = false)
    private String apellidoMaterno;
    @Column(name = "especialidad", length = 100, nullable = false)
    private String especialidad;

}
