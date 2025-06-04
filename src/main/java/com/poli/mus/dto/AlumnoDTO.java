package com.poli.mus.dto;

import jakarta.validation.constraints.*;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Email(message = "El correo debe ser válido")
    private String correo;

    @Min(value = 7, message = "La edad mínima para registrarse es 7 años")
    private Integer edad;

    @Pattern(regexp = "básico|intermedio|avanzado", message = "El nivel debe ser: básico, intermedio o avanzado")
    private String nivel;
}
