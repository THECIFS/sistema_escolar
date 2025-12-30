package com.codefs.SistemaEscolar.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Docente.findByEmail", query = "select d from Docente d where d.correo=:correo"),
        @NamedQuery(name = "Docente.deleteByEmail", query = "delete from Docente d where d.correo=:correo"),
        @NamedQuery(name = "Docente.findByPhone", query = "select d from Docente d where d.telefono=:telefono"),
        @NamedQuery(name = "Docente.findByAddress", query = "select d from Docente d where d.direccion=:direccion"),
        @NamedQuery(name = "Docente.findByStatus", query = "select d from Docente d where d.estatus=:estatus"),
        @NamedQuery(name = "Docente.findBySex", query = "select d from Docente d where d.sexo=:sexo"),
        @NamedQuery(name = "Docente.findBySpecialty", query = "select d from Docente d where d.especialidad=:especialidad")
})

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "docentes")
@DiscriminatorValue("DOCENTE")
public class Docente extends Persona{
    @Column
    private String especialidad;
    @JsonManagedReference
    @OneToMany(mappedBy = "docente", fetch = FetchType.LAZY)
    private List<Inscripcion> inscripciones = new ArrayList<>();
}
