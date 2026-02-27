package com.weg.gestao_escolar.application.dto.professor;

public record ProfessorRequestDTO(
        String nome,
        String email,
        String disciplina
) {
}
