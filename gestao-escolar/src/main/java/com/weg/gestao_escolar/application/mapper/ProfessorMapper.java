package com.weg.gestao_escolar.application.mapper;

import com.weg.gestao_escolar.application.dto.professor.ProfessorRequestDTO;
import com.weg.gestao_escolar.application.dto.professor.ProfessorResponseDTO;
import com.weg.gestao_escolar.domain.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {
    public Professor requestToEntity (ProfessorRequestDTO professorResponseDTO){
        return new Professor(
                professorResponseDTO.nome(),
                professorResponseDTO.email(),
                professorResponseDTO.disciplina()
        );
    }

    public ProfessorResponseDTO responseToEntity(Professor professor){
        return new ProfessorResponseDTO(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getDisciplina()
        );
    }
}
