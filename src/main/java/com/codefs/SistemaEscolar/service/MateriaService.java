package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dao.CarreraDAO;
import com.codefs.SistemaEscolar.dao.DocenteDAO;
import com.codefs.SistemaEscolar.dao.MateriaDAO;
import com.codefs.SistemaEscolar.dto.MateriaDTO;
import com.codefs.SistemaEscolar.mapper.Mapper;
import com.codefs.SistemaEscolar.model.Carrera;
import com.codefs.SistemaEscolar.model.Docente;
import com.codefs.SistemaEscolar.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MateriaService implements IMateria{

    @Autowired
    private MateriaDAO dao;
    @Autowired
    private DocenteDAO dao_docente;
    @Autowired
    private CarreraDAO dao_carrera;

    @Override
    public MateriaDTO save(MateriaDTO materiaDTO) {

        if(materiaDTO!=null && materiaDTO.id_carrera()==null  && materiaDTO.id_docente()==null){

            Docente docente = dao_docente.findById(materiaDTO.id_docente()).orElseThrow(()-> {
                throw new RuntimeException("El id del docente no existe: "+materiaDTO.id_docente());
            });

            Carrera carrera = dao_carrera.findById(materiaDTO.id_carrera()).orElseThrow(()->{
                throw new RuntimeException("El id de la carrera no existe: "+materiaDTO.id_carrera());
            });

            Materia materia = Materia.builder()
                    .nombre(materiaDTO.nombre())
                    .creditos(materiaDTO.creditos())
                    .parciales(materiaDTO.parciales())
                    .horas(materiaDTO.horas())
                    .semestre(materiaDTO.semestre())
                    .inscripciones(new ArrayList<>())
                    .build();

            return Mapper.toDTO(dao.save(materia));
        }

        return null;
    }

    @Override
    public MateriaDTO updateById(UUID id, MateriaDTO materiaDTO) {
        return null;
    }

    @Override
    public MateriaDTO updateByName(String name, MateriaDTO materiaDTO) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public MateriaDTO findById(UUID id) {
        return null;
    }

    @Override
    public List<MateriaDTO> findByName(String name) {
        return List.of();
    }

    @Override
    public List<MateriaDTO> findByPartial(Byte partial) {
        return List.of();
    }

    @Override
    public List<MateriaDTO> findByHours(Float hours) {
        return List.of();
    }

    @Override
    public List<MateriaDTO> findBySemester(Byte semester) {
        return List.of();
    }

    @Override
    public List<MateriaDTO> findByCareer(UUID id_career) {
        return List.of();
    }

    @Override
    public List<MateriaDTO> findByTeacching(UUID id_teaching) {
        return List.of();
    }

    @Override
    public List<MateriaDTO> findAll() {
        return List.of();
    }
}
