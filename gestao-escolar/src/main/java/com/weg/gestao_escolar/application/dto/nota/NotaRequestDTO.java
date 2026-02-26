package com.weg.gestao_escolar.application.dto.nota;

public record NotaRequestDTO(
        int alunoId,
        int aulaId,
        double valor
) {
}
