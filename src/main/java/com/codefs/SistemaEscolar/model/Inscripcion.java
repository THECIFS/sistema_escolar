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

@NamedQueries(
        {
                @NamedQuery(name = "Inscripcion.findByDate", query = "select i from Inscripcion i where i.fechaInscripcion=:fechaInscripcion"),
                @NamedQuery(name = "Inscripcion.findBySchoolYear", query = "select i from Inscripcion i where i.cicloEscolar=:cicloEscolar"),
                @NamedQuery(name = "Inscripcion.findByStudentId", query = "select i from Inscripcion i where i.alumno.id=:id_alumno"),
                @NamedQuery(name = "Inscripcion.findByGroupId", query = "select i from Inscripcion i where i.grupo.id=:id_grupo"),
                @NamedQuery(name = "Inscripcion.findBySubjectId", query = "select i from Inscripcion i where i.materia.id=:id_materia"),
                @NamedQuery(name = "Inscripcion.findByTeachingId", query = "select i from Inscripcion i where i.docente.id=:id_docente")
        }
)

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
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_docente")
    private Docente docente;
}
