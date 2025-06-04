package com.poli.mus.controller;

import com.poli.mus.dto.ClaseDTO;
import com.poli.mus.entity.Clase;
import com.poli.mus.service.interfaces.IClaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {

    private final IClaseService claseService;

    public ClaseController(IClaseService claseService) {
        this.claseService = claseService;
    }

    @GetMapping("/salud")
    public String salud() {
        return "ClaseController activo";
    }

    @GetMapping
    public List<Clase> listarClases() {
        return claseService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Clase obtenerClasePorId(@PathVariable Integer id) {
        return claseService.obtenerPorId(id);
    }
    @PostMapping("/asignar")
    public Clase asignarClase(@RequestBody ClaseDTO claseDTO) {
        return claseService.asignarClaseAProfesor(claseDTO);
    }

    @PostMapping
    public Clase crearClase(@RequestBody Clase clase) {
        return claseService.crearClase(clase);
    }

    @PutMapping("/{id}")
    public Clase actualizarClase(@PathVariable Integer id, @RequestBody Clase claseActualizada) {
        return claseService.actualizarClase(id, claseActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminarClase(@PathVariable Integer id) {
        claseService.eliminarClase(id);
    }
}
