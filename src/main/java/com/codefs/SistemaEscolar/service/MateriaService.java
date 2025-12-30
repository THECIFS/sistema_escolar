package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dao.CarreraDAO;
import com.codefs.SistemaEscolar.dao.DocenteDAO;
import com.codefs.SistemaEscolar.dao.MateriaDAO;
import com.codefs.SistemaEscolar.dto.MateriaDTO;
import com.codefs.SistemaEscolar.mapper.Mapper;
import com.codefs.SistemaEscolar.model.Carrera;
import com.codefs.SistemaEscolar.model.Docente;
import com.codefs.SistemaEscolar.model.Materia;
import jakarta.transaction.Transactional;
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

        if(materiaDTO!=null && materiaDTO.id_carrera()!=null ){

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
                    .carrera(carrera)
                    .build();

            return Mapper.toDTO(dao.save(materia));
        }

        return null;
    }

    @Override
    public MateriaDTO updateById(UUID id, MateriaDTO materiaDTO) {

        Materia materia = dao.findById(id).orElseThrow(()->{throw new RuntimeException("");});

        Carrera carrera = dao_carrera.findById(materiaDTO.id_carrera()).orElseThrow(()->{throw new RuntimeException("");});

        if(materia!=null){
            materia.setCreditos(materiaDTO.creditos());
            materia.setCarrera(carrera);
            materia.setHoras(materiaDTO.horas());
            materia.setNombre(materiaDTO.nombre());
            materia.setParciales(materiaDTO.parciales());
            materia.setSemestre(materiaDTO.semestre());
            return Mapper.toDTO(dao.save(materia));
        }

        return null;
    }

    @Override
    public MateriaDTO updateByName(String name, MateriaDTO materiaDTO) {
        Materia materia = dao.findByNameAndMajorId(name, materiaDTO.id_carrera()).orElseThrow(()->{throw new RuntimeException("");});
        if(materia!=null){
            materia.setSemestre(materiaDTO.semestre());
            materia.setCreditos(materiaDTO.creditos());
            materia.setHoras(materiaDTO.horas());
            materia.setParciales(materiaDTO.parciales());
            return Mapper.toDTO(dao.save(materia));
        }

        return null;
    }

    @Override
    public void deleteById(UUID id) {
        Materia materia = dao.findById(id).orElseThrow(()->{throw new RuntimeException("");});
        if(materia!=null){
            dao.deleteById(id);
        }
    }

    @Transactional
    @Override
    public void deleteByName(String name, Integer id_career) {
        Materia materia = dao.findByNameAndMajorId(name, id_career).orElseThrow(()->{throw new RuntimeException("");});
        if(materia!=null){
            dao.deleteByNameAndMajorId(name, id_career);
        }
    }

    @Override
    public MateriaDTO findById(UUID id) {
        return Mapper.toDTO(dao.findById(id).orElseThrow(()->{throw new RuntimeException("");}));
    }

    @Override
    public List<MateriaDTO> findByName(String name) {
        return dao.findByName(name).orElseThrow(()-> new RuntimeException("")).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<MateriaDTO> findByPartial(Byte partial) {
        return dao.findByPartial(partial).orElseThrow(()->new RuntimeException("")).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<MateriaDTO> findByHours(Float hours) {
        return dao.findByHours(hours).orElseThrow(()->new RuntimeException("")).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<MateriaDTO> findBySemester(Byte semester) {
        return dao.findBySemester(semester).orElseThrow(()->new RuntimeException("")).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<MateriaDTO> findByCareer(Integer id_career) {
        return dao.findByCareerId(id_career).orElseThrow(()->new RuntimeException("")).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<MateriaDTO> findAll() {
        return dao.findAll().stream().map(Mapper::toDTO).toList();
    }
}
