package com.weg.gestao_escolar.application.service;

import com.weg.gestao_escolar.application.dto.aluno.AlunoRequestDTO;
import com.weg.gestao_escolar.application.dto.aluno.AlunoResponseDTO;
import com.weg.gestao_escolar.application.mapper.AlunoMapper;
import com.weg.gestao_escolar.domain.model.Aluno;
import com.weg.gestao_escolar.domain.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

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
            throw new RuntimeException("Erro ao salvar Aluno! " + e);
        }
    }

    public AlunoResponseDTO findById(int id){
        try {
            Aluno aluno = alunoRepository.findById(id);

            AlunoResponseDTO alunoResponseDTO = alunoMapper.responseToEntity(aluno);

            return alunoResponseDTO;

        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException("Erro ao procurar aluno com id! "+e);
        }
    }

    public List<AlunoResponseDTO> findAll(){
        try {

            return alunoRepository.findAll().stream()
                    .map(alunoMapper :: responseToEntity)
                    .toList();

        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(AlunoRequestDTO alunoRequestDTO){
        try {
            Aluno aluno = alunoMapper.requestToEntity(alunoRequestDTO);

            alunoRepository.update(aluno);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar aluno! "+e);
        }
    }
}
