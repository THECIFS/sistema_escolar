package com.codefs.SistemaEscolar.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NamedQueries(
        {
                @NamedQuery(name = "Calificacion.findByPartial", query = "select c from Calificacion c where c.parcial=:parcial and c.inscripcion.id=:id"),
                @NamedQuery(name = "Calificacion.findByStatus", query = "select c from Calificacion c where c.estatus=:estatus and c.inscripcion.id=:id"),
                @NamedQuery(name = "Calificacion.findByRegistrationId", query = "select c from Calificacion c where c.inscripcion.id=:id")
        }
)

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "calificacioness")
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "parcial")
    private Byte parcial;
    @Column(name = "calificacion_final")
    private Float calificacionFinal;
    @Column(name = "estatus")
    private Boolean estatus;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_inscripcion")
    private Inscripcion inscripcion;
}
