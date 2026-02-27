package com.weg.gestao_escolar.application.service;

import com.weg.gestao_escolar.application.dto.aluno.AlunoResponseDTO;
import com.weg.gestao_escolar.application.dto.aula.AulaRequestDTO;
import com.weg.gestao_escolar.application.dto.aula.AulaResponseDTO;
import com.weg.gestao_escolar.application.mapper.AulaMapper;
import com.weg.gestao_escolar.domain.model.Aula;
import com.weg.gestao_escolar.domain.repository.AulaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AulaService {

    private final AulaRepository aulaRepository;
    private final AulaMapper aulaMapper;

    public AulaService(AulaRepository aulaRepository, AulaMapper aulaMapper){
        this.aulaRepository=aulaRepository;
        this.aulaMapper=aulaMapper;
    }

    public AulaResponseDTO save(AulaRequestDTO aulaRequestDTO){
        try {
            Aula aula = aulaMapper.requestToEntity(aulaRequestDTO);

            aulaRepository.save(aula);

            return aulaMapper.responseToEntity(aula);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<AulaResponseDTO> findAll(){
        try {
            return aulaRepository.findAll().stream()
                    .map(aulaMapper::responseToEntity)
                    .toList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public AulaResponseDTO findById(int id){
        try {
            Aula aula = aulaRepository.findById(id);

            return aulaMapper.responseToEntity(aula);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public AulaResponseDTO update(AulaRequestDTO aulaRequestDTO){
        try {
            Aula aula =aulaMapper.requestToEntity(aulaRequestDTO);

            aulaRepository.update(aula);

            return aulaMapper.responseToEntity(aula);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id){
        try {
            aulaRepository.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
