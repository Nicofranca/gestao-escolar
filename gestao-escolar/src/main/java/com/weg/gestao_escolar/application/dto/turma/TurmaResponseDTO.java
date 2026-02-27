package com.weg.gestao_escolar.application.dto.turma;

public record TurmaResponseDTO(
        int id,
        String nome,
        int cursoId,
        int professorId
) {
}
