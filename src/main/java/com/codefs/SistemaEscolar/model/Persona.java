package com.codefs.SistemaEscolar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "personas")
@DiscriminatorColumn(name = "tipo_persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "sexo")
    private Character sexo;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    private String correo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "estatus")
    private Boolean estatus;
}
