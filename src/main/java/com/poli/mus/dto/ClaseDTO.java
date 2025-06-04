package com.poli.mus.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ClaseDTO {

    @NotNull(message = "El ID del profesor no puede ser nulo")
    private Integer profesorId;  // ID del profesor

    @NotNull(message = "El ID de la sala no puede ser nulo")
    private Integer salaId;      // ID de la sala donde se dicta la clase

    @NotNull(message = "El ID del instrumento no puede ser nulo")
    private Integer instrumentoId; // ID del instrumento

    @NotNull(message = "El horario no puede ser nulo")
    @Future(message = "El horario debe ser en el futuro")
    private LocalDateTime horario; // Fecha y hora en que se dicta la clase
}
