package com.example.sistema_academico.controller;

import com.example.sistema_academico.model.Aluno;
import com.example.sistema_academico.repository.AlunoRepository;
import com.example.sistema_academico.model.Curso; // Importante
import com.example.sistema_academico.repository.CursoRepository; // Importante
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository; // Precisamos disso para a matrícula

    // 1. Listar (GET)
    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    // 2. Criar Aluno (POST)
    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    // 3. MATRÍCULA (O botão que estava faltando!)
    @PostMapping("/{idAluno}/matricula/{idCurso}")
    public Aluno matricular(@PathVariable Long idAluno, @PathVariable Long idCurso) {
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Curso curso = cursoRepository.findById(idCurso).orElseThrow(() -> new RuntimeException("Curso não encontrado"));
        
        aluno.getCursos().add(curso);
        return alunoRepository.save(aluno);
    }
}