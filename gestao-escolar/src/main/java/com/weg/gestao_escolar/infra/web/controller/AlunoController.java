package com.weg.gestao_escolar.infra.web.controller;

import com.weg.gestao_escolar.application.dto.aluno.AlunoRequestDTO;
import com.weg.gestao_escolar.application.dto.aluno.AlunoResponseDTO;
import com.weg.gestao_escolar.application.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<AlunoResponseDTO> findAll(){
        return alunoService.findAll();
    }

    @GetMapping("/{id}")
    public AlunoResponseDTO findById(@PathVariable int id){
        return alunoService.findById(id);
    }

    @PostMapping
    public AlunoResponseDTO save(@Valid  @RequestBody AlunoRequestDTO alunoRequestDTO){
        return alunoService.save(alunoRequestDTO);
    }

    @PutMapping("/{id}")
    public AlunoResponseDTO update(@Valid @RequestBody AlunoRequestDTO alunoRequestDTO){
        return alunoService.update(alunoRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        alunoService.delete(id);
    }
}
