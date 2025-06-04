package com.poli.mus.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ProfesorDTO {

    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no debe superar los 100 caracteres")
    private String nombre;

    @Size(max = 100, message = "La especialidad no debe superar los 100 caracteres")
    private String especialidad;

    @Size(max = 50, message = "La disponibilidad no debe superar los 50 caracteres")
    private String disponibilidad;
}
