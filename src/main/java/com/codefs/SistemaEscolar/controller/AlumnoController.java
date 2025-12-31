package com.codefs.SistemaEscolar.controller;

import com.codefs.SistemaEscolar.dto.AlumnoDTO;
import com.codefs.SistemaEscolar.model.Alumno;
import com.codefs.SistemaEscolar.service.AlumnoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/students")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody AlumnoDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable UUID id, @RequestBody AlumnoDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.updateById(id, dto));
    }

    @PutMapping("/email")
    public ResponseEntity<?> updateByEmail(@RequestParam String email, @RequestBody AlumnoDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.updateByEmail(email, dto));
    }

    @PutMapping("/enrollment")
    public ResponseEntity<?> updateByEnrollment(@RequestParam String enrollment, @RequestBody AlumnoDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.updateByEnrollment(enrollment, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        alumnoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/email")
    public ResponseEntity<?> deleteByEmail(@RequestParam String email) {
        alumnoService.deleteByEmail(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/enrollment")
    public ResponseEntity<?> deleteByEnrollment(@RequestParam String enrollment) {
        alumnoService.deleteByEnrollment(enrollment);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.findById(id));
    }

    @GetMapping("/email")
    public ResponseEntity<AlumnoDTO> findByEmail(@RequestParam String email) {
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.findByEmail(email));
    }

    @GetMapping("/phone")
    public ResponseEntity<AlumnoDTO> findByPhone(@RequestParam String phone) {
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.findByPhone(phone));
    }

    @GetMapping("/address")
    public ResponseEntity<List<AlumnoDTO>> findByAddress(@RequestParam String address) {
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.findByAddress(address));
    }

    @GetMapping("/status")
    public ResponseEntity<List<AlumnoDTO>> findByStatus(@RequestParam Boolean status){
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.findByStatus(status));
    }

    @GetMapping("/sex")
    public ResponseEntity<List<AlumnoDTO>> findBySex(@RequestParam Character sex){
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.findBySex(sex));
    }

    @GetMapping("/enrollment")
    public ResponseEntity<AlumnoDTO> findByEnrollMent(@RequestParam String enrollment){
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.findByEnrollment(enrollment));
    }

    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.findAll());
    }
}
