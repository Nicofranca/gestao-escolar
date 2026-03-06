package com.weg.gestao_escolar.application.dto.aula;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record AulaRequestDTO(

        @NotNull
        int turmaId,

        @PastOrPresent
        LocalDate dataHora,

        @NotEmpty
        String assunto
) {
}
