package com.codefs.SistemaEscolar.controller;

import com.codefs.SistemaEscolar.dto.CalificacionDTO;
import com.codefs.SistemaEscolar.model.Calificacion;
import com.codefs.SistemaEscolar.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/ratings")
public class CalificacionController {
    @Autowired
    private CalificacionService calificacionService;

    @GetMapping
    public ResponseEntity<List<CalificacionDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(calificacionService.findAll());
    }

    @GetMapping("/registration")
    public ResponseEntity<List<CalificacionDTO>> findByRegistrationId(@RequestParam UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(calificacionService.findByRegistrationId(id));
    }

    @GetMapping("/status")
    public ResponseEntity<List<CalificacionDTO>> findByStatus(@RequestParam Boolean status, @RequestParam UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(calificacionService.findByStatus(status, id));
    }

    @GetMapping("/partial")
    public ResponseEntity<List<CalificacionDTO>> findByPartial(@RequestParam Byte partial, @RequestParam UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(calificacionService.findByPartial(partial, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalificacionDTO> findById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(calificacionService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CalificacionDTO> updateById(@PathVariable UUID id, @RequestBody CalificacionDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(calificacionService.updateById(id, dto));
    }

    @PostMapping
    public ResponseEntity<CalificacionDTO> save(@RequestBody CalificacionDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(calificacionService.save(dto));
    }
}
