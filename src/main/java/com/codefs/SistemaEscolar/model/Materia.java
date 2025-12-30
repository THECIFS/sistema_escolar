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

@NamedQueries({
        @NamedQuery(name = "Materia.findByNameAndMajorId", query = "select m from Materia m where m.nombre=:nombre and m.carrera.id=:id_career"),
        @NamedQuery(name = "Materia.deleteByNameAndMajorId", query = "delete from Materia m where m.nombre=:nombre and m.carrera.id=:id_career"),
        @NamedQuery(name = "Materia.findByName", query = "select m from Materia m where m.nombre=:nombre"),
        @NamedQuery(name = "Materia.findByPartial", query = "select m from Materia m where m.parciales=:parciales"),
        @NamedQuery(name = "Materia.findByHours", query = "select m from Materia m where m.horas=:horas"),
        @NamedQuery(name = "Materia.finBySemester", query = "select m from Materia m where m.semestre=:semestre"),
        @NamedQuery(name = "Materia.findByCareerId", query = "select m from Materia m where m.carrera.id=:id_career")
})

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
}
