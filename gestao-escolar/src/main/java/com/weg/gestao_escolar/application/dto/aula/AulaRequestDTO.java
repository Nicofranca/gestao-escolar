package com.weg.gestao_escolar.application.dto.aula;

import java.time.LocalDate;

public record AulaRequestDTO(
        int turmaId,
        LocalDate dataHora,
        String assunto
) {
}
