package com.codefs.SistemaEscolar.controller;

import com.codefs.SistemaEscolar.dto.InscripcionDTO;
import com.codefs.SistemaEscolar.service.InscripcionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/registrations")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping
    public ResponseEntity<List<InscripcionDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(inscripcionService.findAll());
    }

    @GetMapping("/teachings")
    public ResponseEntity<List<InscripcionDTO>> findByTeachingId(@RequestParam UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(inscripcionService.findByTeachingId(id));
    }

    @GetMapping("/subjects")
    public ResponseEntity<List<InscripcionDTO>> findBySubjectId(@RequestParam UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(inscripcionService.findBySubjectId(id));
    }

    @GetMapping("/groups")
    public ResponseEntity<List<InscripcionDTO>> findByGroupId(@RequestParam UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(inscripcionService.findByGroupId(id));
    }

    @GetMapping("/students")
    public ResponseEntity<List<InscripcionDTO>> findByStudentId(@RequestParam UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(inscripcionService.findByStudentId(id));
    }

    @GetMapping("/schoolYear")
    public ResponseEntity<List<InscripcionDTO>> findBySchoolYear(@RequestParam String schoolYear){
        return ResponseEntity.status(HttpStatus.OK).body(inscripcionService.findBySchoolYear(schoolYear));
    }

    @GetMapping("/date")
    public ResponseEntity<List<InscripcionDTO>> findByDate(@RequestParam LocalDate date){
        return ResponseEntity.status(HttpStatus.OK).body(inscripcionService.findByDate(date));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscripcionDTO> findById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(inscripcionService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id){
        inscripcionService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscripcionDTO> updateById(@PathVariable UUID id, @RequestBody InscripcionDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(inscripcionService.updateById(id,dto));
    }

    @PostMapping
    public ResponseEntity<InscripcionDTO> save(@RequestBody InscripcionDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(inscripcionService.save(dto));
    }

}
