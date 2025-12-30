package com.codefs.SistemaEscolar.controller;

import com.codefs.SistemaEscolar.dto.MateriaDTO;
import com.codefs.SistemaEscolar.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/subjects")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public ResponseEntity<List<MateriaDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(materiaService.findAll());
    }

    @GetMapping("/career")
    public ResponseEntity<List<MateriaDTO>> findByCareerId(@RequestParam Integer id_career){
        return ResponseEntity.status(HttpStatus.OK).body(materiaService.findByCareer(id_career));
    }

    @GetMapping("/semester")
    public ResponseEntity<List<MateriaDTO>> findBySemester(@RequestParam Byte semester){
        return ResponseEntity.status(HttpStatus.OK).body(materiaService.findBySemester(semester));
    }

    @GetMapping("/hours")
    public ResponseEntity<List<MateriaDTO>> findByHours(@RequestParam Float hours){
        return ResponseEntity.status(HttpStatus.OK).body(materiaService.findByHours(hours));
    }

    @GetMapping("/partials")
    public ResponseEntity<List<MateriaDTO>> findByPartial(@RequestParam Byte partial){
        return ResponseEntity.status(HttpStatus.OK).body(materiaService.findByPartial(partial));
    }

    @GetMapping("/name")
    public ResponseEntity<List<MateriaDTO>> findByName(@RequestParam String name){
        return ResponseEntity.status(HttpStatus.OK).body(materiaService.findByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaDTO> findById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(materiaService.findById(id));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteByName(@RequestParam String name, @RequestParam Integer id_career){
        materiaService.deleteByName(name, id_career);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id){
        materiaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/name")
    public ResponseEntity<MateriaDTO> updateByName(@RequestParam String name,@RequestBody MateriaDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(materiaService.updateByName(name, dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MateriaDTO> updateById(@PathVariable UUID id, @RequestBody MateriaDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(materiaService.updateById(id,dto));
    }

    @PostMapping
    public ResponseEntity<MateriaDTO> save(@RequestBody MateriaDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(materiaService.save(dto));
    }

}
