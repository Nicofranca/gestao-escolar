package com.weg.gestao_escolar.application.service;

import com.weg.gestao_escolar.application.dto.aluno.AlunoRequestDTO;
import com.weg.gestao_escolar.application.dto.aluno.AlunoResponseDTO;
import com.weg.gestao_escolar.application.mapper.AlunoMapper;
import com.weg.gestao_escolar.domain.model.Aluno;
import com.weg.gestao_escolar.domain.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class AlunoService {

    public final AlunoRepository alunoRepository;
    public final AlunoMapper alunoMapper;

    public AlunoService(AlunoRepository alunoRepository, AlunoMapper alunoMapper){
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
    }

    public AlunoResponseDTO save(AlunoRequestDTO alunoRequestDTO) {
        try {
            Aluno aluno = alunoMapper.requestToEntity(alunoRequestDTO);

            alunoRepository.save(aluno);

            AlunoResponseDTO alunoResponseDTO = alunoMapper.responseToEntity(aluno);

            return alunoResponseDTO;

        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException("Erro ao salvar Aluno!" + e);
        }
    }


}
