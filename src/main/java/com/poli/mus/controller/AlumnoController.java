package com.poli.mus.controller;

import com.poli.mus.dto.AlumnoDTO;
import com.poli.mus.entity.Alumno;
import com.poli.mus.service.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @PostMapping
    public ResponseEntity<Alumno> guardar(@Valid @RequestBody AlumnoDTO alumnoDTO) {
        Alumno alumnoCreado = alumnoService.guardar(alumnoDTO);
        return ResponseEntity.ok(alumnoCreado);
    }

    @GetMapping
    public ResponseEntity<List<Alumno>> listar() {
        return ResponseEntity.ok(alumnoService.listar());
    }
}
