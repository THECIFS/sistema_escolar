package com.codefs.SistemaEscolar.dto;

import java.time.LocalDate;
import java.util.UUID;

public record PersonaDTO(
        UUID id,
        String nombre,
        String apellidoPaterno,
        String apellidoMaterno,
        String direccion,
        Character sexo,
        LocalDate fechaNacimiento,
        String correo,
        String telefono,
        Boolean estatus
) {
}
