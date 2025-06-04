package com.poli.mus.service.interfaces;

import com.poli.mus.entity.Inscripcion;

public interface IInscripcionService {
    Inscripcion inscribirAlumnoAClase(Integer alumnoId, Integer claseId);
}
