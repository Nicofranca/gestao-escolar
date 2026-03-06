package com.weg.gestao_escolar.application.service;

import com.weg.gestao_escolar.application.mapper.ProfessorMapper;
import com.weg.gestao_escolar.domain.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    public ProfessorService(ProfessorRepository professorRepository, ProfessorMapper professorMapper){
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
    }
}
