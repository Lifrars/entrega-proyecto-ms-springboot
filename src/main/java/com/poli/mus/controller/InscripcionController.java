package com.poli.mus.controller;

import com.poli.mus.dto.InscripcionDTO;
import com.poli.mus.entity.Inscripcion;
import com.poli.mus.service.interfaces.IInscripcionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    private final IInscripcionService inscripcionService;

    public InscripcionController(IInscripcionService inscripcionService) {
        this.inscripcionService = inscripcionService;
    }


    @PostMapping
    public ResponseEntity<Inscripcion> inscribir(@RequestBody InscripcionDTO dto) {
        Inscripcion inscripcion = inscripcionService.inscribirAlumnoAClase(dto.getAlumnoId(), dto.getClaseId());
        return ResponseEntity.ok(inscripcion);
    }
}
