package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dto.InscripcionDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IInscripcion {

    /*
        crear
        actualizar
            id
        eliminar
            id
        buscar
            id
            fechaInscripcion
            cicloEscolar
            id_alumno
            id_grupo
            id_materia
    */

    public InscripcionDTO save(InscripcionDTO inscripcionDTO);


    public InscripcionDTO updateById(UUID id, InscripcionDTO inscripcionDTO);


    public void deleteById(UUID id);

    public InscripcionDTO findById(UUID id);
    public List<InscripcionDTO> findByDate(LocalDate date);
    public List<InscripcionDTO> findBySchoolYear(String schoolYear);
    public List<InscripcionDTO> findByStudentId(UUID id);
    public List<InscripcionDTO> findByGroupId(UUID id);
    public List<InscripcionDTO> findBySubjectId(UUID id);
}
