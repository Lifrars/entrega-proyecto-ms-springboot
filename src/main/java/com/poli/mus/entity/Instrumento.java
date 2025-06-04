package com.poli.mus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "instrumentos")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Instrumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instrumento_id")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 50)
    private String tipo;

    @Column(length = 50)
    private String estado;
}
