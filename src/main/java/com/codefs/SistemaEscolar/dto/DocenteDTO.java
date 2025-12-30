package com.codefs.SistemaEscolar.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record DocenteDTO(
        UUID id,
        String nombre,
        String apellidoPaterno,
        String apellidoMaterno,
        String direccion,
        Character sexo,
        LocalDate fechaNacimiento,
        String correo,
        String telefono,
        Boolean estatus,
        String especialidad,
        List<InscripcionDTO> inscripciones
) {
}
