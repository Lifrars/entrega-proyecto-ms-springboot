package com.poli.mus.service;

import com.poli.mus.dto.ClaseDTO;
import com.poli.mus.entity.Clase;

import com.poli.mus.entity.Instrumento;
import com.poli.mus.entity.Profesor;
import com.poli.mus.entity.Sala;
import com.poli.mus.exception.ReglaNegocioException;
import com.poli.mus.repository.IClaseRepository;
import com.poli.mus.repository.IIntrumentoRepository;
import com.poli.mus.repository.IProfesorRepository;
import com.poli.mus.repository.ISalaRepository;
import com.poli.mus.service.interfaces.IClaseService;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;

@Service
public class ClaseServiceImpl implements IClaseService {

    private final IClaseRepository claseRepository;
    private final IProfesorRepository profesorRepository;
    private final ISalaRepository salaRepository;
    private final IIntrumentoRepository intrumentoRepository;
    public ClaseServiceImpl(IClaseRepository claseRepository, IProfesorRepository profesorRepository, ISalaRepository salaRepository, IIntrumentoRepository intrumentoRepository) {
        this.claseRepository = claseRepository;
        this.profesorRepository = profesorRepository;
        this.salaRepository = salaRepository;
        this.intrumentoRepository = intrumentoRepository;
    }

    @Override
    public List<Clase> obtenerTodas() {
        return claseRepository.findAll();
    }


    @Override
    public Clase asignarClaseAProfesor(ClaseDTO claseDTO) {
        LocalDate hoy = claseDTO.getHorario().toLocalDate();
        LocalDate inicioSemana = hoy.with(DayOfWeek.MONDAY);
        LocalDate finSemana = hoy.with(DayOfWeek.SUNDAY);
        LocalDateTime inicio = inicioSemana.atStartOfDay();
        LocalDateTime fin = finSemana.atTime(LocalTime.MAX);

        long clasesSemana = claseRepository.contarClasesEstaSemana(
                claseDTO.getProfesorId(), inicio, fin
        );
        if (clasesSemana >= 5) {
            throw new ReglaNegocioException("El profesor ya tiene 5 clases asignadas esta semana.");
        }

        long solapadas = claseRepository.contarClasesSolapadas(
                claseDTO.getProfesorId(), claseDTO.getSalaId(), claseDTO.getHorario()
        );
        if (solapadas > 0) {
            throw new ReglaNegocioException("Ya existe una clase en ese horario con el mismo profesor o en la misma sala.");
        }

        long instrumentoOcupado = claseRepository.contarInstrumentoOcupado(
                claseDTO.getInstrumentoId(), claseDTO.getHorario()
        );
        if (instrumentoOcupado > 0) {
            throw new ReglaNegocioException("El instrumento ya está asignado a otra clase en ese horario.");
        }



        Profesor profesor = profesorRepository.findById(claseDTO.getProfesorId())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        Sala sala = salaRepository.findById(claseDTO.getSalaId())
                .orElseThrow(() -> new RuntimeException("Sala no encontrada"));

        Instrumento instrumento = intrumentoRepository.findById(claseDTO.getInstrumentoId())
                .orElseThrow(() -> new RuntimeException("Instrumento no encontrado"));


        if (!"activo".equalsIgnoreCase(instrumento.getEstado())) {
            throw new ReglaNegocioException("El instrumento no está disponible. Estado actual: " + instrumento.getEstado());
        }
        Clase nuevaClase = toEntity(claseDTO, profesor, sala, instrumento);
        return claseRepository.save(nuevaClase);
    }



    @Override
    public Clase obtenerPorId(Integer id) {
        return claseRepository.findById(id).orElse(null);
    }

    @Override
    public Clase crearClase(Clase clase) {
        return claseRepository.save(clase);
    }

    @Override
    public Clase actualizarClase(Integer id, Clase claseActualizada) {
        Clase existente = claseRepository.findById(id).orElseThrow();
        existente.setHorario(claseActualizada.getHorario());
        existente.setInstrumento(claseActualizada.getInstrumento());
        existente.setProfesor(claseActualizada.getProfesor());
        existente.setSala(claseActualizada.getSala());
        return claseRepository.save(existente);
    }

    @Override
    public void eliminarClase(Integer id) {
        claseRepository.deleteById(id);
    }

    public static Clase toEntity(ClaseDTO dto, Profesor profesor, Sala sala, Instrumento instrumento) {
        Clase clase = new Clase();
        clase.setHorario(dto.getHorario());
        clase.setProfesor(profesor);
        clase.setInstrumento(instrumento);
        clase.setSala(sala);
        return clase;
    }
}
