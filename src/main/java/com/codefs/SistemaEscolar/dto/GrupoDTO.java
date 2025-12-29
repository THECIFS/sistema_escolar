package com.codefs.SistemaEscolar.dto;

import com.codefs.SistemaEscolar.model.Inscripcion;

import java.util.List;
import java.util.UUID;

public record GrupoDTO(
    UUID id,
    Character nombre,
    String cicloEscolar,
    Byte semestre,
    String turno
)
{

}
