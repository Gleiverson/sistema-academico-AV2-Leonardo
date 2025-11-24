package com.example.sistema_academico.repository;

import com.example.sistema_academico.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    // Só de fazer isso, o Spring já aprende a:
    // Salvar, Listar todos, Buscar por ID e Deletar Alunos!
    // Mágica, né?
}