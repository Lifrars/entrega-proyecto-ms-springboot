package com.poli.mus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "salas")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sala_id")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private Integer capacidad;
}
