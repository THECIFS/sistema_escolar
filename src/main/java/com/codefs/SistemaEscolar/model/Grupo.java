package com.codefs.SistemaEscolar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NamedQueries(
        {
                @NamedQuery(name = "Grupo.findByName", query = "select g from Grupo g where g.nombre=:nombre"),
                @NamedQuery(name = "Grupo.findBySchoolYear", query = "select g from Grupo g where g.cicloEscolar=:cicloEscolar"),
                @NamedQuery(name = "Grupo.findBySemester", query = "select g from Grupo g where g.semestre=:semestre"),
                @NamedQuery(name = "Grupo.findByShift", query = "select g from Grupo g where g.turno=:turno")
        }
)

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grupos")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Character nombre;
    private String cicloEscolar;
    private Byte semestre;
    private String turno;
}
