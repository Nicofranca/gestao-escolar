package com.weg.gestao_escolar.infra.web.controller;


import com.weg.gestao_escolar.application.dto.turma.TurmaRequestDTO;
import com.weg.gestao_escolar.application.dto.turma.TurmaResponseDTO;
import com.weg.gestao_escolar.application.service.TurmaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    public final TurmaService turmaService;

    public TurmaController(TurmaService turmaService){
        this.turmaService = turmaService;
    }

    @PostMapping
    public TurmaResponseDTO save(@RequestBody TurmaRequestDTO professorRequestDTO){
        return turmaService.save(professorRequestDTO);
    }

    @GetMapping
    public List<TurmaResponseDTO> findAll(){
        return turmaService.findAll();
    }

    @GetMapping("/{id}")
    public TurmaResponseDTO findById(@PathVariable int id){
        return turmaService.findById(id);
    }

    @PutMapping
    public void update(@RequestBody TurmaRequestDTO professorRequestDTO){
        turmaService.update(professorRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        turmaService.delete(id);
    }
}
