package com.weg.gestao_escolar.application.dto.nota;

public record NotaResponseDTO(
        int id,
        int alunoId,
        int aulaId,
        double valor
) {
}
