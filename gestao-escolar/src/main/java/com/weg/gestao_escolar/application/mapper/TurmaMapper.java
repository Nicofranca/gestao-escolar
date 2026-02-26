package com.weg.gestao_escolar.application.mapper;

import com.weg.gestao_escolar.application.dto.turma.TurmaRequestDTO;
import com.weg.gestao_escolar.application.dto.turma.TurmaResponseDTO;
import com.weg.gestao_escolar.domain.model.Turma;
import org.springframework.stereotype.Component;

@Component
public class TurmaMapper {
    public Turma requestToEntity(TurmaRequestDTO turmaRequestDTO){
        return new Turma(
                turmaRequestDTO.nome(),
                turmaRequestDTO.cursoId(),
                turmaRequestDTO.professorId()
        );
    }

    public TurmaResponseDTO responseToEntity(Turma turma){
        return new TurmaResponseDTO(
                turma.getId(),
                turma.getNome(),
                turma.getCursoId(),
                turma.getProfessorId()
        );
    }
}
