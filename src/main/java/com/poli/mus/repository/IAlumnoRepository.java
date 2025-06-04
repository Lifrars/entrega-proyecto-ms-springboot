package com.poli.mus.repository;

import com.poli.mus.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlumnoRepository extends JpaRepository<Alumno, Integer> {
}
