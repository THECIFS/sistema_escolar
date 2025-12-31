package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dto.DocenteDTO;
import com.codefs.SistemaEscolar.dto.GrupoDTO;

import java.util.List;
import java.util.UUID;

public interface IGrupo {
    /*
        crear
        actualizar
            id
        eliminar
            id
        buscar
            id
            nombre
            cicloEscolar
            semestre
            turno
    */

    public GrupoDTO save(GrupoDTO grupoDTO);


    public GrupoDTO updateById(UUID id, GrupoDTO grupoDTO);


    public void deleteById(UUID id);

    public GrupoDTO findById(UUID id);
    public List<GrupoDTO> findyByName(String name);
    public List<GrupoDTO> findBySchoolYear(String schoolYear);
    public List<GrupoDTO> findBySemester(Byte semester);
    public List<GrupoDTO> findByShift(String shift);
    public List<GrupoDTO> findAll();
}
