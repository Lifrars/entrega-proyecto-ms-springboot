package com.poli.mus.service;

import com.poli.mus.dto.AlumnoDTO;
import com.poli.mus.entity.Alumno;
import com.poli.mus.repository.IAlumnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    private final IAlumnoRepository alumnoRepository;

    public AlumnoService(IAlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public Alumno guardar(AlumnoDTO dto) {
        if (dto.getEdad() < 7) {
            throw new IllegalArgumentException("La edad mínima es 7 años");
        }

        Alumno alumno = Alumno.builder()
                .nombre(dto.getNombre())
                .correo(dto.getCorreo())
                .edad(dto.getEdad())
                .nivel(dto.getNivel())
                .build();

        return alumnoRepository.save(alumno);
    }

    public List<Alumno> listar() {
        return alumnoRepository.findAll();
    }
}
