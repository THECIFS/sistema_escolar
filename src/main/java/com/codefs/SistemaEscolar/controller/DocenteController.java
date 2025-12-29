package com.codefs.SistemaEscolar.controller;

import com.codefs.SistemaEscolar.dto.DocenteDTO;
import com.codefs.SistemaEscolar.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/docentes")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody DocenteDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(docenteService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable UUID id, @RequestBody DocenteDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(docenteService.updateById(id, dto));
    }

    @PutMapping("/email")
    public ResponseEntity<?> updateByEmail(@RequestParam String email, @RequestBody DocenteDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(docenteService.updateByEmail(email, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id){
        docenteService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/email")
    public ResponseEntity<?> deleteByEmail(@RequestParam String email){
        docenteService.deleteByEmail(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(docenteService.findById(id));
    }

    @GetMapping("/email")
    public ResponseEntity<?> findByEmail(@RequestParam String email){
        return ResponseEntity.status(HttpStatus.OK).body(docenteService.findByEmail(email));
    }

    @GetMapping("/phone")
    public ResponseEntity<?> findByPhone(@RequestParam String phone){
        return ResponseEntity.status(HttpStatus.OK).body(docenteService.findByPhone(phone));
    }

    @GetMapping("/address")
    public ResponseEntity<?> findByAddress(@RequestParam String address){
        return ResponseEntity.status(HttpStatus.OK).body(docenteService.findByAddress(address));
    }

    @GetMapping("/status")
    public ResponseEntity<?> findByStatus(@RequestParam Boolean status){
        return ResponseEntity.status(HttpStatus.OK).body(docenteService.findByStatus(status));
    }

    @GetMapping("/sex")
    public ResponseEntity<?> findBySex(@RequestParam Character sex){
        return ResponseEntity.status(HttpStatus.OK).body(docenteService.findBySex(sex));
    }

    @GetMapping("/specialty")
    public ResponseEntity<?> findBySpecialty(@RequestParam String specialty){
        return ResponseEntity.status(HttpStatus.OK).body(docenteService.findBySpecialty(specialty));
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(docenteService.findAll());
    }
}
