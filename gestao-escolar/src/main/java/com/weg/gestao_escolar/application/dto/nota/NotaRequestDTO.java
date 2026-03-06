package com.weg.gestao_escolar.application.dto.nota;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record NotaRequestDTO(
        @NotNull
        @Positive
        int alunoId,

        @NotNull
        @Positive
        int aulaId,

        @NotNull
        @PositiveOrZero
        double valor
) {
}
