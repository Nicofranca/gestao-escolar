package com.weg.gestao_escolar.application.dto.professor;

public record ProfessorResponseDTO(
        int id,
        String nome,
        String email,
        String disciplina

) {
}
