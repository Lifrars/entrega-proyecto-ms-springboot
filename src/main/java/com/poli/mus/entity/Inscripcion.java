package com.poli.mus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inscripciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inscripcion {

    @EmbeddedId
    private InscripcionId id;

    @ManyToOne
    @MapsId("alumnoId")
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne
    @MapsId("claseId")
    @JoinColumn(name = "clase_id")
    private Clase clase;
}
