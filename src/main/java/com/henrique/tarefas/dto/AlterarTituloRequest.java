package com.henrique.tarefas.dto;

import jakarta.validation.constraints.NotBlank;


public record AlterarTituloRequest(@NotBlank String titulo) {

}
