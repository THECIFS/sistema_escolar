package com.codefs.SistemaEscolar.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inscripciones")
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "fecha_inscripcion")
    private LocalDate fechaInscripcion;
    @Column(name = "ciclo_escolar")
    private String cicloEscolar;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;
    @ManyToOne
    @JoinColumn(name = "id_grupo")
    private Grupo grupo;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "inscripcion")
    private List<Calificacion> calificaciones = new ArrayList<>();
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Materia materia;
}
