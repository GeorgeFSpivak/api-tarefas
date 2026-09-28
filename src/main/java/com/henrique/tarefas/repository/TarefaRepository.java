package com.henrique.tarefas.repository;

import com.henrique.tarefas.model.Tarefa;
import  org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
