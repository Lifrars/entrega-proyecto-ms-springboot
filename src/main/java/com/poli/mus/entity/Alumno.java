package com.poli.mus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "alumnos")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumno_id")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 100)
    private String correo;

    @Column
    private Integer edad;

    @Column(length = 50)
    private String nivel;
}
