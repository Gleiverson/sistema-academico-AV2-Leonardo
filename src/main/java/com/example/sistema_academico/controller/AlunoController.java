package com.example.sistema_academico.controller;

import com.example.sistema_academico.model.Aluno;
import com.example.sistema_academico.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Diz que essa classe recebe pedidos da internet (JSON)
@RequestMapping("/alunos") // O endereço será: seusite.com/alunos
public class AlunoController {

    @Autowired // O Spring injeta o repositório aqui automaticamente
    private AlunoRepository alunoRepository;

    // 1. Listar todos os alunos (GET)
    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    // 2. Cadastrar um novo aluno (POST)
    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }
}