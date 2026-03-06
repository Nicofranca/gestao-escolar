package com.weg.gestao_escolar.application.dto.turma;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TurmaRequestDTO(

        @NotBlank
        String nome,

        @NotNull
        @Positive
        int cursoId,

        @NotNull
        @Positive
        int professorId
) {
}
