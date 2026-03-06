package com.weg.gestao_escolar.application.service;

import com.weg.gestao_escolar.application.dto.professor.ProfessorRequestDTO;
import com.weg.gestao_escolar.application.dto.professor.ProfessorResponseDTO;
import com.weg.gestao_escolar.application.mapper.ProfessorMapper;
import com.weg.gestao_escolar.domain.model.Professor;
import com.weg.gestao_escolar.domain.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    public ProfessorService(ProfessorRepository professorRepository, ProfessorMapper professorMapper){
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
    }

    public ProfessorResponseDTO save(ProfessorRequestDTO professorRequestDTO){
        try {
            Professor professor = professorMapper.requestToEntity(professorRequestDTO);

            professorRepository.save(professor);

            return professorMapper.responseToEntity(professor);
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public ProfessorResponseDTO findById(int id){
        try {
            Professor professor = professorRepository.findById(id);

            return professorMapper.responseToEntity(professor);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProfessorResponseDTO> findAll(){
        try {
            return professorRepository.findAll().stream()
                    .map(professorMapper::responseToEntity)
                    .toList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(ProfessorRequestDTO professorRequestDTO){
        try {
            Professor professor = professorMapper.requestToEntity(professorRequestDTO);

            professorRepository.update(professor);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id){
        try {
            professorRepository.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
