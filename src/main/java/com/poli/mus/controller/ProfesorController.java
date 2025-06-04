package com.poli.mus.controller;

import com.poli.mus.dto.ProfesorDTO;
import com.poli.mus.entity.Profesor;
import com.poli.mus.service.interfaces.IProfesorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final IProfesorService profesorService;

    public ProfesorController(IProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping("/salud")
    public String salud() {
        return "ProfesorController activo";
    }

    @GetMapping
    public List<Profesor> listarProfesores() {
        return profesorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Profesor obtenerPorId(@PathVariable Integer id) {
        return profesorService.obtenerPorId(id);
    }

    @PostMapping
    public Profesor crearProfesor(@RequestBody @Valid ProfesorDTO dto) {
        return profesorService.crear(dto);
    }


    @PutMapping("/{id}")
    public Profesor actualizarProfesor(@PathVariable Integer id, @RequestBody Profesor actualizado) {
        return profesorService.actualizar(id, actualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarProfesor(@PathVariable Integer id) {
        profesorService.eliminar(id);
    }
}
