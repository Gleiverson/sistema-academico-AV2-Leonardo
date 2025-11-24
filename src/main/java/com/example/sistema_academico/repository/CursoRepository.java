package com.example.sistema_academico.repository;

import com.example.sistema_academico.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    // Pronto! O funcionário que cuida dos Cursos está contratado.
}