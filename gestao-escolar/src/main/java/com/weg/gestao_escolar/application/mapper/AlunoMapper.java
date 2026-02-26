package com.weg.gestao_escolar.application.mapper;

import com.weg.gestao_escolar.application.dto.aluno.AlunoRequestDTO;
import com.weg.gestao_escolar.application.dto.aluno.AlunoResponseDTO;
import com.weg.gestao_escolar.domain.model.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {
    public Aluno requestToEntity(AlunoRequestDTO alunoRequestDTO){
        return new Aluno(
                alunoRequestDTO.nome(),
                alunoRequestDTO.email(),
                alunoRequestDTO.matricula(),
                alunoRequestDTO.dataNascimento()
        );
    }

    public AlunoResponseDTO responseToEntity(Aluno aluno){
        return new AlunoResponseDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getMatricula(),
                aluno.getDataNascimento()
        );
    }
}
