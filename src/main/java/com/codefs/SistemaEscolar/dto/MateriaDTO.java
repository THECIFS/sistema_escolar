package com.codefs.SistemaEscolar.dto;

import com.codefs.SistemaEscolar.model.Inscripcion;

import java.util.List;
import java.util.UUID;

public record MateriaDTO(
        UUID id,
        String nombre,
        Float creditos,
        Byte parciales,
        Float horas,
        Byte semestre,
        List<InscripcionDTO> inscripciones,
        Integer id_carrera
) {
}
