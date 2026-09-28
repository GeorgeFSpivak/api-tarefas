package com.henrique.tarefas.dto;

import jakarta.validation.constraints.NotBlank;

public record CriarTarefaRequest(@NotBlank String titulo) {

}
