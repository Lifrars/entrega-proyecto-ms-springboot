package com.poli.mus.repository;

import com.poli.mus.entity.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;


public interface IClaseRepository extends JpaRepository<Clase, Integer> {
    @Query("SELECT COUNT(*) FROM Clase c WHERE c.profesor.id = :profesorId AND c.horario BETWEEN :inicioSemana AND :finSemana")
    long contarClasesEstaSemana(
            @Param("profesorId") Integer profesorId,
            @Param("inicioSemana") java.time.LocalDateTime inicioSemana,
            @Param("finSemana") java.time.LocalDateTime finSemana
    );

    @Query("SELECT COUNT(c) FROM Clase c " +
            "WHERE c.horario = :horario AND " +
            "(c.profesor.id = :profesorId OR c.sala.id = :salaId)")
    long contarClasesSolapadas(@Param("profesorId") Integer profesorId,
                               @Param("salaId") Integer salaId,
                               @Param("horario") LocalDateTime horario);

    @Query("SELECT COUNT(c) FROM Clase c WHERE c.instrumento.id = :instrumentoId AND c.horario = :horario")
    long contarInstrumentoOcupado(@Param("instrumentoId") Integer instrumentoId,
                                  @Param("horario") LocalDateTime horario);


}
