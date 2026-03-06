package com.weg.gestao_escolar.application.service;

import com.weg.gestao_escolar.application.dto.curso.CursoRequestDTO;
import com.weg.gestao_escolar.application.dto.curso.CursoResponseDTO;
import com.weg.gestao_escolar.application.mapper.CursoMapper;
import com.weg.gestao_escolar.domain.model.Curso;
import com.weg.gestao_escolar.domain.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;

    public CursoService(CursoRepository cursoRepository, CursoMapper cursoMapper){
        this.cursoRepository=cursoRepository;
        this.cursoMapper=cursoMapper;
    }

    public CursoResponseDTO save(CursoRequestDTO cursoRequestDTO){
        try {
            Curso curso = cursoMapper.requestToEntity(cursoRequestDTO);

            cursoRepository.save(curso);

            return cursoMapper.responseToEntity(curso);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<CursoResponseDTO> findAll(){
        try {
            return cursoRepository.findAll().stream()
                    .map(cursoMapper::responseToEntity)
                    .toList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CursoResponseDTO findById(int id){
        try {
            Curso curso = cursoRepository.findById(id);

            return cursoMapper.responseToEntity(curso);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(CursoRequestDTO cursoRequestDTO){
        try {
            Curso curso = cursoMapper.requestToEntity(cursoRequestDTO);

            cursoRepository.update(curso);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(int id){
        try {
            cursoRepository.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
