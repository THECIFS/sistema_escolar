package com.codefs.SistemaEscolar.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Carrera.findpByName", query = "select c from Carrera c where c.nombre=:nombre"),
        @NamedQuery(name = "Carrera.deleteByName", query = "delete from Carrera c where c.nombre=:nombre"),
        @NamedQuery(name = "Carrera.findByLevel", query = "select c from Carrera c where c.nivel=:nivel"),
        @NamedQuery(name = "Carrera.findByDuration", query = "select c from Carrera c where c.duracion=:duracion")
})

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carreras")
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nivel")
    private String nivel;
    @Column(name = "duracion")
    private Float duracion;
    @JsonManagedReference
    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
    private List<Materia> materias = new ArrayList<>();
}
