package com.weg.gestao_escolar.infra.web.controller;

import com.weg.gestao_escolar.application.dto.aluno.AlunoRequestDTO;
import com.weg.gestao_escolar.application.dto.aluno.AlunoResponseDTO;
import com.weg.gestao_escolar.application.dto.aula.AulaRequestDTO;
import com.weg.gestao_escolar.application.dto.aula.AulaResponseDTO;
import com.weg.gestao_escolar.application.service.AulaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aula")
public class AulaController {

    private final AulaService aulaService;

    public AulaController(AulaService aulaService){
        this.aulaService=aulaService;
    }

    @GetMapping
    public List<AulaResponseDTO> findAll(){
        return aulaService.findAll();
    }

    @GetMapping("/{id}")
    public AulaResponseDTO findById(@PathVariable int id){
        return aulaService.findById(id);
    }

    @PostMapping
    public AulaResponseDTO save(@RequestBody AulaRequestDTO aulaRequestDTO){
        return aulaService.save(aulaRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        aulaService.delete(id);
    }
}
