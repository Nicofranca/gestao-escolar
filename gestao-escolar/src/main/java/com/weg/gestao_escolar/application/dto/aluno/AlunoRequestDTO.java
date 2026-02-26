package com.weg.gestao_escolar.application.dto.aluno;

import java.time.LocalDate;

public record AlunoRequestDTO (
        String nome,
        String email,
        String matricula,
        LocalDate dataNascimento
){
}
