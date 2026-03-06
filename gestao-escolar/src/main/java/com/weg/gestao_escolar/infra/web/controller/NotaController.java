package com.weg.gestao_escolar.infra.web.controller;

import com.weg.gestao_escolar.application.dto.nota.NotaRequestDTO;
import com.weg.gestao_escolar.application.dto.nota.NotaResponseDTO;
import com.weg.gestao_escolar.application.mapper.NotaMapper;
import com.weg.gestao_escolar.application.service.NotaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nota")
public class NotaController {

    public final NotaService notaService;

    public NotaController(NotaService notaService){
        this.notaService = notaService;
    }

    @GetMapping
    public List<NotaResponseDTO> findAll(){
        return notaService.findAll();
    }

    @PostMapping
    public NotaResponseDTO save(@RequestBody NotaRequestDTO notaRequestDTO){
        return notaService.save(notaRequestDTO);
    }

    @GetMapping("/{id}")
    public NotaResponseDTO findById(@PathVariable int id){
        return notaService.findById(id);
    }

    @PutMapping
    public void update(@RequestBody NotaRequestDTO notaRequestDTO){
        notaService.update(notaRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        notaService.delete(id);
    }
}
