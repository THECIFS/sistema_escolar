package com.codefs.SistemaEscolar.dto;

import java.util.UUID;

public record CalificacionDTO(
        UUID id,
        Byte parcial,
        Float calificacionFinal,
        Boolean estatus,
        UUID id_inscripcion
) {
}
