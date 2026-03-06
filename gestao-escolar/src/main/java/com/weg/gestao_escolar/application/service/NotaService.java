package com.weg.gestao_escolar.application.service;

import com.weg.gestao_escolar.application.dto.nota.NotaRequestDTO;
import com.weg.gestao_escolar.application.dto.nota.NotaResponseDTO;
import com.weg.gestao_escolar.application.mapper.NotaMapper;
import com.weg.gestao_escolar.domain.model.Nota;
import com.weg.gestao_escolar.domain.repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class NotaService {

    private final NotaRepository notaRepository;
    private final NotaMapper notaMapper;

    public NotaService(NotaRepository notaRepository, NotaMapper notaMapper){
        this.notaRepository = notaRepository;
        this.notaMapper= notaMapper;
    }

    public NotaResponseDTO save(NotaRequestDTO notaRequestDTO){
        try {
            Nota nota = notaMapper.requestToEntity(notaRequestDTO);

            notaRepository.save(nota);

            return notaMapper.responseToEntity(nota);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public NotaResponseDTO findById(int id){
        try {
            Nota nota = notaRepository.findById(id);

            return notaMapper.responseToEntity(nota);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<NotaResponseDTO> findAll(){
        try {
            return notaRepository.findAll().stream()
                    .map(notaMapper::responseToEntity)
                    .toList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(NotaRequestDTO notaRequestDTO){
        try {
            Nota nota = notaMapper.requestToEntity(notaRequestDTO);

            notaRepository.update(nota);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id){
        try {
            notaRepository.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
