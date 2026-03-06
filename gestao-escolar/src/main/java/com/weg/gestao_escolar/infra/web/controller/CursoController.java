package com.weg.gestao_escolar.infra.web.controller;

import com.weg.gestao_escolar.application.dto.curso.CursoRequestDTO;
import com.weg.gestao_escolar.application.dto.curso.CursoResponseDTO;
import com.weg.gestao_escolar.application.service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    public final CursoService cursoService;

    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<CursoResponseDTO> findAll(){
        return cursoService.findAll();
    }

    @GetMapping("/{id}")
    public CursoResponseDTO findById(@PathVariable int id){
        return cursoService.findById(id);
    }

    @PostMapping
    public CursoResponseDTO save(@RequestBody CursoRequestDTO cursoRequestDTO){
        return cursoService.save(cursoRequestDTO);
    }

    @PutMapping
    public void update(@RequestBody CursoRequestDTO cursoRequestDTO){
        cursoService.update(cursoRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        cursoService.delete(id);
    }
}
