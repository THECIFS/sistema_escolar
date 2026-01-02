package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dao.GrupoDAO;
import com.codefs.SistemaEscolar.dto.GrupoDTO;
import com.codefs.SistemaEscolar.exception.ResourceNotFound;
import com.codefs.SistemaEscolar.mapper.Mapper;
import com.codefs.SistemaEscolar.model.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GrupoService implements IGrupo{

    @Autowired
    private GrupoDAO dao;

    @Override
    public GrupoDTO save(GrupoDTO grupoDTO) {
        Grupo grupo = Grupo.builder()
                .nombre(grupoDTO.nombre())
                .cicloEscolar(grupoDTO.cicloEscolar())
                .semestre(grupoDTO.semestre())
                .turno(grupoDTO.turno())
                .build();
        return Mapper.toDTO(dao.save(grupo));
    }

    @Override
    public GrupoDTO updateById(UUID id, GrupoDTO grupoDTO) {
        Grupo grupo =  dao.findById(id).orElseThrow(()->new ResourceNotFound("El id del grupo: "+id+" no fue encontrado"));
         grupo.setNombre(grupoDTO.nombre());
            grupo.setCicloEscolar(grupoDTO.cicloEscolar());
            grupo.setTurno(grupoDTO.turno());
            grupo.setSemestre(grupoDTO.semestre());
            return Mapper.toDTO(dao.save(grupo));
    }

    @Override
    public void deleteById(UUID id) {
        Grupo grupo = dao.findById(id).orElseThrow(()->new ResourceNotFound("El id del grupo: "+id+" no fue encontrado"));
            dao.deleteById(id);
    }

    @Override
    public GrupoDTO findById(UUID id) {
        return Mapper.toDTO(dao.findById(id).orElseThrow(()->new ResourceNotFound("El id del grupo: "+id+" no fue encontrado")));
    }

    @Override
    public List<GrupoDTO> findyByName(String name) {
        return dao.findByName(name).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<GrupoDTO> findBySchoolYear(String schoolYear) {
        return dao.findBySchoolYear(schoolYear).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<GrupoDTO> findBySemester(Byte semester) {
        return dao.findBySemester(semester).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<GrupoDTO> findByShift(String shift) {
        return dao.findByShift(shift).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<GrupoDTO> findAll() {
        return dao.findAll().stream().map(Mapper::toDTO).toList();
    }
}
