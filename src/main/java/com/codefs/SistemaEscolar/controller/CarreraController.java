package com.codefs.SistemaEscolar.controller;

import com.codefs.SistemaEscolar.dto.CarreraDTO;
import com.codefs.SistemaEscolar.model.Carrera;
import com.codefs.SistemaEscolar.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/careers")
public class CarreraController {
    @Autowired
    private CarreraService carreraService;

    @GetMapping
    public ResponseEntity<List<CarreraDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(carreraService.findAll());
    }

    @GetMapping("/duration")
    public ResponseEntity<List<CarreraDTO>> findByDuration(@RequestParam Float duration){
        return ResponseEntity.status(HttpStatus.OK).body(carreraService.findByDuration(duration));
    }

    @GetMapping("/level")
    public ResponseEntity<List<CarreraDTO>> findByLevel(@RequestParam String level){
        return ResponseEntity.status(HttpStatus.OK).body(carreraService.findByLevel(level));
    }

    @GetMapping("/name")
    public ResponseEntity<CarreraDTO> findByName(String name){
        return ResponseEntity.status(HttpStatus.OK).body(carreraService.findByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarreraDTO> findById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(carreraService.findById(id));
    }

    @DeleteMapping("/name")
    public ResponseEntity<?> deleteByName(@RequestParam String name){
        carreraService.deleteByName(name);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        carreraService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/name")
    public ResponseEntity<CarreraDTO> updateByName(@RequestParam String name, @RequestBody CarreraDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(carreraService.updateByName(name,dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarreraDTO> updateById(@PathVariable Integer id, @RequestBody CarreraDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(carreraService.updateById(id,dto));
    }

    @PostMapping
    public ResponseEntity<CarreraDTO> save(@RequestBody CarreraDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(carreraService.save(dto));
    }
}
