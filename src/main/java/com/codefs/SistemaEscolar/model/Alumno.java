package com.codefs.SistemaEscolar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NamedQueries(
        {
                @NamedQuery(name = "Alumno.findByEmail", query = "select a from Alumno a where a.correo=:correo"),
                @NamedQuery(name = "Alumno.findByEnrollment", query = "select a from Alumno a where a.matricula=:matricula"),
                @NamedQuery(name = "Alumno.findByPhone", query = "select a from Alumno a where a.telefono=:telefono"),
                @NamedQuery(name = "Alumno.findByAddress", query = "select a from Alumno a where a.direccion=:direccion"),
                @NamedQuery(name = "Alumno.findByStatus", query = "select a from Alumno a where a.estatus=:estatus"),
                @NamedQuery(name = "Alumno.findBySex", query = "select a from Alumno a where a.sexo=:sexo"),
                @NamedQuery(name = "Alumno.deleteByEmail", query = "delete from Alumno a where a.correo=:correo"),
                @NamedQuery(name = "Alumno.deleteByEnrollment", query = "delete from Alumno a where a.matricula=:matricula")
        }
)

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alumnos")
@DiscriminatorValue("ALUMNO")
public class Alumno extends Persona{
    @Column(name = "matricula")
    private String matricula;
}
