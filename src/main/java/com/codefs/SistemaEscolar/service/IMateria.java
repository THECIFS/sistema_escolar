package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dto.MateriaDTO;

import java.util.List;
import java.util.UUID;

public interface IMateria {
    /*
        crear
        actualizar
            id
            nombre
        eliminar
            id
            nombre
        buscar
            id
            nombre
            parciales
            horas
            semestre
            id_carrera
            id_docente
     */

    public MateriaDTO save(MateriaDTO materiaDTO);

    public MateriaDTO updateById(UUID id, MateriaDTO materiaDTO);
    public MateriaDTO updateByName(String name, MateriaDTO materiaDTO);


    public void deleteById(UUID id);
    public void deleteByName(String name);


    public MateriaDTO findById(UUID id);
    public List<MateriaDTO> findByName(String name);
    public List<MateriaDTO> findByPartial(Byte partial);
    public List<MateriaDTO> findByHours(Float hours);
    public List<MateriaDTO> findBySemester(Byte semester);
    public List<MateriaDTO> findByCareer(UUID id_career);
    public List<MateriaDTO> findByTeacching(UUID id_teaching);
    public List<MateriaDTO> findAll();

}
