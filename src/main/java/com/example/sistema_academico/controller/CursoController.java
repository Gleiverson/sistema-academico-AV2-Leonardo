package com.example.sistema_academico.controller;

import com.example.sistema_academico.model.Curso;
import com.example.sistema_academico.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    // 1. Listar todos os cursos
    @GetMapping
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    // 2. Cadastrar um novo curso
    @PostMapping
    public Curso criarCurso(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }
}