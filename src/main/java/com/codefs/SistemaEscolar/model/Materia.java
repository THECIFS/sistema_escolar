package com.codefs.SistemaEscolar.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "materias")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "creditos")
    private Float creditos;
    @Column(name = "parciales")
    private Byte parciales;
    @Column(name = "horas_semana")
    private Float horas;
    @Column(name = "semestre")
    private Byte semestre;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "materia")
    private List<Inscripcion> inscripciones = new ArrayList<>();
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_docente")
    private Docente docente;
}
