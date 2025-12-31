package com.codefs.SistemaEscolar.controller;

import com.codefs.SistemaEscolar.dto.GrupoDTO;
import com.codefs.SistemaEscolar.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/groups")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;


    @GetMapping
    public ResponseEntity<List<GrupoDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(grupoService.findAll());
    }

    @GetMapping("/shift")
    public ResponseEntity<List<GrupoDTO>> findByShift(@RequestParam String shift){
        return ResponseEntity.status(HttpStatus.OK).body(grupoService.findByShift(shift));
    }

    @GetMapping("/semester")
    public ResponseEntity<List<GrupoDTO>> findBySemester(@RequestParam Byte semester){
        return ResponseEntity.status(HttpStatus.OK).body(grupoService.findBySemester(semester));
    }

    @GetMapping("/schoolYear")
    public ResponseEntity<List<GrupoDTO>> findBySchoolYear(@RequestParam String schoolYear){
        return ResponseEntity.status(HttpStatus.OK).body(grupoService.findBySchoolYear(schoolYear));
    }

    @GetMapping("/name")
    public ResponseEntity<List<GrupoDTO>> findByName(@RequestParam String name){
        return ResponseEntity.status(HttpStatus.OK).body(grupoService.findyByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoDTO> findById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(grupoService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GrupoDTO> deleteByName(@PathVariable UUID id){
        grupoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrupoDTO> updateById(@PathVariable UUID id, @RequestBody GrupoDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(grupoService.updateById(id, dto));
    }

    @PostMapping
    public ResponseEntity<GrupoDTO> save(@RequestBody GrupoDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(grupoService.save(dto));
    }
}
