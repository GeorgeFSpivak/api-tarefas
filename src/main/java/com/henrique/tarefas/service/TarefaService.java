package com.henrique.tarefas.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import com.henrique.tarefas.model.Tarefa;
import com.henrique.tarefas.repository.TarefaRepository;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> listar() {

        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> buscarPorId(long id) {
        return tarefaRepository.findById(id);

    }

    @Transactional
    public Tarefa criar(String titulo) {
        Tarefa tarefa = new Tarefa(titulo);

        return tarefaRepository.save(tarefa);
    }

    @Transactional
    public Optional<Tarefa> concluir(long id) {
        Optional<Tarefa> resultado =  buscarPorId(id);

        if (resultado.isPresent()) {
            Tarefa tarefa = resultado.get();

            tarefa.concluir();
            tarefaRepository.save(tarefa);
        }

        return resultado;

    }

    @Transactional
    public boolean excluir(long id) {
        Optional<Tarefa> resultado = buscarPorId(id);

        if (resultado.isPresent()) {
            Tarefa tarefa = resultado.get();

            tarefaRepository.delete(tarefa);
            return true;
        }

        return false;
    }

    @Transactional
    public Optional<Tarefa> alterarTitulo(long id, String novoTitulo) {
        Optional<Tarefa> resultado = buscarPorId(id);

        if (resultado.isPresent()) {
            Tarefa tarefa = resultado.get();

            tarefa.alterarTitulo(novoTitulo);
            tarefaRepository.save(tarefa);
        }

        return resultado;

    }

}
