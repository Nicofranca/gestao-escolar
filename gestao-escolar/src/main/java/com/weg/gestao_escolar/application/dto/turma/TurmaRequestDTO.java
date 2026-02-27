package com.weg.gestao_escolar.application.dto.turma;

public record TurmaRequestDTO(
        String nome,
        int cursoId,
        int professorId
) {
}
