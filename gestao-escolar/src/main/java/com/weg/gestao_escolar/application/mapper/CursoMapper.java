package com.weg.gestao_escolar.application.mapper;

import com.weg.gestao_escolar.application.dto.curso.CursoRequestDTO;
import com.weg.gestao_escolar.application.dto.curso.CursoResponseDTO;
import com.weg.gestao_escolar.domain.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {
    public Curso requestToEntity(CursoRequestDTO cursoRequestDTO){
        return new Curso(
                cursoRequestDTO.nome(),
                cursoRequestDTO.codigo()
        );
    }

    public CursoResponseDTO responseToEntity(Curso curso){
        return new CursoResponseDTO(
                curso.getId(),
                curso.getNome(),
                curso.getCodigo()
        );
    }
}
