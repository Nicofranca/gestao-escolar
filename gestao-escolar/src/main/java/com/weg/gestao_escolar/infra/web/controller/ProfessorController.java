package com.weg.gestao_escolar.infra.web.controller;

import com.weg.gestao_escolar.application.dto.professor.ProfessorRequestDTO;
import com.weg.gestao_escolar.application.dto.professor.ProfessorResponseDTO;
import com.weg.gestao_escolar.application.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    public final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }

    @PostMapping
    public ProfessorResponseDTO save(@RequestBody ProfessorRequestDTO professorRequestDTO){
        return professorService.save(professorRequestDTO);
    }

    @GetMapping
    public List<ProfessorResponseDTO> findAll(){
        return professorService.findAll();
    }

    @GetMapping("/{id}")
    public ProfessorResponseDTO findById(@PathVariable int id){
        return professorService.findById(id);
    }

    @PutMapping
    public void update(@RequestBody ProfessorRequestDTO professorRequestDTO){
        professorService.update(professorRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        professorService.delete(id);
    }
}