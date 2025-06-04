package com.poli.mus.service.interfaces;

import com.poli.mus.dto.ProfesorDTO;
import com.poli.mus.entity.Profesor;

import java.util.List;

public interface IProfesorService {
    List<Profesor> obtenerTodos();
    Profesor obtenerPorId(Integer id);
    Profesor crear(ProfesorDTO profesor);
    Profesor actualizar(Integer id, Profesor actualizado);
    void eliminar(Integer id);
}
