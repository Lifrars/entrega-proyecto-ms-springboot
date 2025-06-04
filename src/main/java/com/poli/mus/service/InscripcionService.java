package com.poli.mus.service;

import com.poli.mus.entity.Alumno;
import com.poli.mus.entity.Clase;
import com.poli.mus.entity.Inscripcion;
import com.poli.mus.entity.InscripcionId;
import com.poli.mus.exception.ReglaNegocioException;
import com.poli.mus.repository.IAlumnoRepository;
import com.poli.mus.repository.IClaseRepository;
import com.poli.mus.repository.IInscripcionRepository;
import com.poli.mus.service.interfaces.IInscripcionService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InscripcionService implements IInscripcionService {

    private final IInscripcionRepository inscripcionRepository;
    private final IClaseRepository claseRepository;
    private final IAlumnoRepository alumnoRepository;

    public InscripcionService(IInscripcionRepository inscripcionRepository, IClaseRepository claseRepository, IAlumnoRepository alumnoRepository) {
        this.inscripcionRepository = inscripcionRepository;
        this.claseRepository = claseRepository;
        this.alumnoRepository = alumnoRepository;
    }
    @Override
    public Inscripcion inscribirAlumnoAClase(Integer alumnoId, Integer claseId) {
        List<Inscripcion> inscripcionesActuales = inscripcionRepository.findByAlumnoId(alumnoId);
        System.out.println("perro traes el omnitrix");
        System.out.println(inscripcionesActuales.size());
        if (inscripcionesActuales.size() >= 3) {
            throw new ReglaNegocioException("El alumno ya tiene 3 clases activas");
        }

        Alumno alumno = alumnoRepository.findById(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        Clase clase = claseRepository.findById(claseId)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));

        InscripcionId id = new InscripcionId();
        id.setAlumnoId(alumno.getId());
        id.setClaseId(clase.getId());

        Inscripcion inscripcion = Inscripcion.builder()
                .id(id)
                .alumno(alumno)
                .clase(clase)
                .build();


        return inscripcionRepository.save(inscripcion);
    }
}
