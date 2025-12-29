package com.codefs.SistemaEscolar.dto;

import com.codefs.SistemaEscolar.model.Calificacion;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record InscripcionDTO(
        UUID id,
        LocalDate fechaInscripcion,
        String cicloEscolar,
        UUID id_alumno,
        UUID id_grupo,
        UUID id_materia,
        List<CalificacionDTO> calificaciones
) {
}
