package com.codefs.SistemaEscolar.dto;

import com.codefs.SistemaEscolar.model.Materia;

import java.util.List;

public record CarreraDTO (
        Integer id,
        String nombre,
        String nivel,
        Float duracion,
        List<MateriaDTO> materias
){

}
