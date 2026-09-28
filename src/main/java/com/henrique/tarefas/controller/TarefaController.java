package com.henrique.tarefas.controller;

import com.henrique.tarefas.dto.CriarTarefaRequest;
import com.henrique.tarefas.dto.AlterarTituloRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import jakarta.validation.Valid;
import com.henrique.tarefas.model.Tarefa;
import com.henrique.tarefas.service.TarefaService;
import java.util.List;
import java.util.Optional;

@RestController
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {

        this.tarefaService = tarefaService;
    }

    @GetMapping("/tarefas")
    public List<Tarefa> listarTarefas() {

        return tarefaService.listar();

    }

    @GetMapping("/tarefas/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable("id") long id) {

        Optional<Tarefa> resultado = tarefaService.buscarPorId(id);

        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resultado.get());

    }

    @PostMapping("/tarefas")
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody @Valid CriarTarefaRequest request) {
        Tarefa tarefa = tarefaService.criar(request.titulo());

        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);

    }

    @PostMapping("/tarefas/{id}/concluir")
    public ResponseEntity<Tarefa> concluirTarefa(@PathVariable("id") long id) {

        Optional<Tarefa> resultado = tarefaService.concluir(id);

        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resultado.get());

    }

    @PatchMapping("/tarefas/{id}")
    public ResponseEntity<Tarefa> alterarTitulo(@PathVariable("id") long id, @RequestBody @Valid AlterarTituloRequest request) {
        Optional<Tarefa> resultado = tarefaService.alterarTitulo(id, request.titulo());

        if (resultado.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resultado.get());
    }


    @DeleteMapping("/tarefas/{id}")
    public ResponseEntity<Void> excluirTarefa(@PathVariable("id") long id) {

        boolean resultado = tarefaService.excluir(id);

        if (resultado) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();

    }

}
