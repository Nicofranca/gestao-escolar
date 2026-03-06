package com.weg.gestao_escolar.application.service;

import com.weg.gestao_escolar.application.dto.turma.TurmaRequestDTO;
import com.weg.gestao_escolar.application.dto.turma.TurmaResponseDTO;
import com.weg.gestao_escolar.application.mapper.TurmaMapper;
import com.weg.gestao_escolar.domain.model.Turma;
import com.weg.gestao_escolar.domain.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final TurmaMapper turmaMapper;

    public TurmaService(TurmaRepository turmaRepository, TurmaMapper turmaMapper){
        this.turmaRepository = turmaRepository;
        this.turmaMapper = turmaMapper;
    }

    public TurmaResponseDTO save(TurmaRequestDTO professorRequestDTO){
        try {
            Turma professor = turmaMapper.requestToEntity(professorRequestDTO);

            turmaRepository.save(professor);

            return turmaMapper.responseToEntity(professor);
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public TurmaResponseDTO findById(int id){
        try {
            Turma professor = turmaRepository.findById(id);

            return turmaMapper.responseToEntity(professor);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TurmaResponseDTO> findAll(){
        try {
            return turmaRepository.findAll().stream()
                    .map(turmaMapper::responseToEntity)
                    .toList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(TurmaRequestDTO professorRequestDTO){
        try {
            Turma professor = turmaMapper.requestToEntity(professorRequestDTO);

            turmaRepository.update(professor);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id){
        try {
            turmaRepository.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
