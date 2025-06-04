package com.poli.mus.service.interfaces;

import com.poli.mus.dto.ClaseDTO;
import com.poli.mus.entity.Clase;

import java.util.List;

public interface IClaseService {
    List<Clase> obtenerTodas();

    Clase asignarClaseAProfesor(ClaseDTO claseDTO);

    Clase obtenerPorId(Integer id);
    Clase crearClase(Clase clase);
    Clase actualizarClase(Integer id, Clase claseActualizada);
    void eliminarClase(Integer id);
}
