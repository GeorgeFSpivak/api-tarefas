package com.henrique.tarefas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private boolean concluida;

    protected Tarefa() {
    }

    public Tarefa(String titulo) {
        this.titulo = titulo;
        this.concluida = false;
    }

    public Long getId() {

        return id;
    }

    public String getTitulo() {

        return titulo;

    }

    public void alterarTitulo(String novoTitulo) {
        this.titulo = novoTitulo;
    }

    public boolean isConcluida() {

        return concluida;

    }

    public void concluir() {

        this.concluida = true;

    }

}
