package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dao.*;
import com.codefs.SistemaEscolar.dto.InscripcionDTO;
import com.codefs.SistemaEscolar.mapper.Mapper;
import com.codefs.SistemaEscolar.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class InscripcionService implements IInscripcion{

    @Autowired
    private InscripcionDAO dao;

    @Autowired
    private AlumnoDAO alumno_dao;

    @Autowired
    private GrupoDAO grupo_dao;

    @Autowired
    private MateriaDAO materia_dao;

    @Autowired
    private DocenteDAO docente_dao;

    @Override
    public InscripcionDTO save(InscripcionDTO inscripcionDTO) {

        Alumno alumno = alumno_dao.findById(inscripcionDTO.id_alumno()).orElseThrow(()->new RuntimeException("No se encontro el alumno"));

        Grupo grupo = grupo_dao.findById(inscripcionDTO.id_grupo()).orElseThrow(()->new RuntimeException("No se encontro el grupo"));

        Materia materia = materia_dao.findById(inscripcionDTO.id_materia()).orElseThrow(()->new RuntimeException("No se encontro la materia"));

        Docente docente = docente_dao.findById(inscripcionDTO.id_docente()).orElseThrow(()->new RuntimeException("No se encontro el docente"));

        Inscripcion inscripcion = Inscripcion.builder()
                .fechaInscripcion(LocalDate.now())
                .cicloEscolar(inscripcionDTO.cicloEscolar())
                .alumno(alumno)
                .grupo(grupo)
                .calificaciones(new ArrayList<>())
                .materia(materia)
                .docente(docente)
                .build();

        return Mapper.toDTO(dao.save(inscripcion));
    }

    @Override
    public InscripcionDTO updateById(UUID id, InscripcionDTO inscripcionDTO) {

        Inscripcion inscripcion = dao.findById(id).orElseThrow(()->new RuntimeException(""));

        Alumno alumno = alumno_dao.findById(id).orElseThrow(()->new RuntimeException(""));

        Grupo grupo = grupo_dao.findById(inscripcionDTO.id_grupo()).orElseThrow(()->new RuntimeException(""));

        Materia materia = materia_dao.findById(inscripcionDTO.id_materia()).orElseThrow(()->new RuntimeException(""));

        Docente docente = docente_dao.findById(inscripcionDTO.id_docente()).orElseThrow(()->new RuntimeException(""));

        inscripcion.setAlumno(alumno);
        inscripcion.setGrupo(grupo);
        inscripcion.setMateria(materia);
        inscripcion.setDocente(docente);

        return Mapper.toDTO(dao.save(inscripcion));
    }

    @Override
    public void deleteById(UUID id) {
        Inscripcion inscripcion = dao.findById(id).orElseThrow(()->new RuntimeException(""));
        if(inscripcion!=null){
            dao.deleteById(id);
        }
    }

    @Override
    public InscripcionDTO findById(UUID id) {
        return Mapper.toDTO(dao.findById(id).orElseThrow(()->new RuntimeException("")));
    }

    @Override
    public List<InscripcionDTO> findByDate(LocalDate date) {
        return dao.findByDate(date).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<InscripcionDTO> findBySchoolYear(String schoolYear) {
        return dao.findBySchoolYear(schoolYear).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<InscripcionDTO> findByStudentId(UUID id) {
        return dao.findByStudentId(id).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<InscripcionDTO> findByGroupId(UUID id) {
        return dao.findByGroupId(id).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<InscripcionDTO> findBySubjectId(UUID id) {
        return dao.findBySubjectId(id).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<InscripcionDTO> findByTeachingId(UUID id) {
        return dao.findByTeachingId(id).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<InscripcionDTO> findAll() {
        return dao.findAll().stream().map(Mapper::toDTO).toList();
    }
}
