package com.poli.mus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profesores")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesor_id")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 100)
    private String especialidad;

    @Column(length = 50)
    private String disponibilidad;
}
