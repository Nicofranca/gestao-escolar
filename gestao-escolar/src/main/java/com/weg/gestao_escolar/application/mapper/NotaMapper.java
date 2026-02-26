package com.weg.gestao_escolar.application.mapper;

import com.weg.gestao_escolar.application.dto.nota.NotaRequestDTO;
import com.weg.gestao_escolar.application.dto.nota.NotaResponseDTO;
import com.weg.gestao_escolar.domain.model.Nota;
import org.springframework.stereotype.Component;

@Component
public class NotaMapper {
    public Nota requestToEntity(NotaRequestDTO notaRequestDTO){
        return new Nota(
                notaRequestDTO.alunoId(),
                notaRequestDTO.aulaId(),
                notaRequestDTO.valor()
        );
    }

    public NotaResponseDTO responseToEntity(Nota nota){
        return new NotaResponseDTO(
                nota.getId(),
                nota.getAlunoId(),
                nota.getAulaId(),
                nota.getValor()
        );
    }
}
