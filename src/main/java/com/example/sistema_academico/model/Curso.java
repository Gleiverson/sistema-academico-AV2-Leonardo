/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sistema_academico.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity // Isso avisa ao banco de dados: "Crie uma tabela para guardar Cursos"
public class Curso {

    @Id // Este é o código identificador único
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco cria o número sozinho (1, 2, 3...)
    private Long id;

    private String nome;
    private int cargaHoraria; // [cite: 78]

    @ManyToMany(mappedBy = "cursos") // Diz que a lista de alunos está controlada do outro lado
    @JsonIgnore
    private List<Aluno> alunos = new ArrayList<>();

    // --- Construtores e Getters/Setters (O jeito de acessar os dados) ---
    
    public Curso() {} // Obrigatório ter um vazio

    public Curso(String nome, int cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(int cargaHoraria) { this.cargaHoraria = cargaHoraria; }

    public List<Aluno> getAlunos() { return alunos; }
    public void setAlunos(List<Aluno> alunos) { this.alunos = alunos; }
}