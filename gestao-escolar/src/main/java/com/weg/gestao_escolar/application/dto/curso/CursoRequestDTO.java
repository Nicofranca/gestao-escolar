package com.weg.gestao_escolar.application.dto.curso;

import jakarta.validation.constraints.NotBlank;

public record CursoRequestDTO(

    @NotBlank
    String nome,

    @NotBlank
    String codigo
) {
}
