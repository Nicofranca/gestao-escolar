package com.weg.gestao_escolar.application.dto.aluno;

import java.time.LocalDate;

public record AlunoResponseDTO(
        int id,
        String nome,
        String email,
        String matricula,
        LocalDate dataNascimento
) {
}
