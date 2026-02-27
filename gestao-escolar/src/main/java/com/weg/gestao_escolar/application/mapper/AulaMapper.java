package com.weg.gestao_escolar.application.mapper;

import com.weg.gestao_escolar.application.dto.aula.AulaRequestDTO;
import com.weg.gestao_escolar.application.dto.aula.AulaResponseDTO;
import com.weg.gestao_escolar.domain.model.Aula;
import org.springframework.stereotype.Component;

@Component
public class AulaMapper {
    public Aula requestToEntity(AulaRequestDTO aula){
        return new Aula(
                aula.assunto(),
                aula.dataHora(),
                aula.turmaId()
        );
    }

    public AulaResponseDTO responseToEntity(Aula aula){
        return new AulaResponseDTO(
                aula.getId(),
                aula.getTurmaId(),
                aula.getDataHora(),
                aula.getAssunto()
        );
    }
}
