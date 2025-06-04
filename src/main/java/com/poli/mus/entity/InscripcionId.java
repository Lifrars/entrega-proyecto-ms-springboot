package com.poli.mus.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
public class InscripcionId implements Serializable {
    private Integer alumnoId;
    private Integer claseId;
}
