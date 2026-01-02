package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dao.CarreraDAO;
import com.codefs.SistemaEscolar.dao.MateriaDAO;
import com.codefs.SistemaEscolar.dto.CarreraDTO;
import com.codefs.SistemaEscolar.exception.ResourceNotFound;
import com.codefs.SistemaEscolar.mapper.Mapper;
import com.codefs.SistemaEscolar.model.Carrera;
import com.codefs.SistemaEscolar.model.Materia;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CarreraService implements ICarrera{

    @Autowired
    private CarreraDAO dao;

    @Autowired
    private MateriaDAO materiaDAO;

    @Override
    public CarreraDTO save(CarreraDTO carreraDTO) {
            System.out.println("Punto de control save");
            System.out.println(carreraDTO.toString());
            Carrera carrera = Carrera.builder()
                    .nombre(carreraDTO.nombre())
                    .duracion(carreraDTO.duracion())
                    .nivel(carreraDTO.nivel())
                    .materias(new ArrayList<>())
                    .build();

            Carrera c = dao.save(carrera);
            System.out.println(c.toString());
            return Mapper.toDTO(c);
    }

    @Transactional
    @Override
    public CarreraDTO updateById(Integer id, CarreraDTO carreraDTO) {
        Carrera carrera = dao.findById(id).orElseThrow(()->new ResourceNotFound("El id de la carrera: "+id+" no fue encontrada"));
            carrera.setNombre(carreraDTO.nombre());
            carrera.setNivel(carreraDTO.nivel());
            carrera.setDuracion(carreraDTO.duracion());
            return Mapper.toDTO(dao.save(carrera));
    }

    @Transactional
    @Override
    public CarreraDTO updateByName(String name, CarreraDTO carreraDTO) {
        Carrera carrera = dao.findByName(name).orElseThrow(()->new ResourceNotFound("El nombre de la carrera: "+name+" no fue encontrada"));
            carrera.setNivel(carreraDTO.nivel());
            carrera.setNivel(carreraDTO.nivel());
            return Mapper.toDTO(carrera);
    }

    @Override
    public void deleteById(Integer id) {
        Carrera carrera = dao.findById(id).orElseThrow(()->new ResourceNotFound("El id de la carrera: "+id+" no fue encontrada"));
        if(carrera!=null){
            dao.deleteById(id);
        }
    }

    @Transactional
    @Override
    public void deleteByName(String name) {
        Carrera carrera = dao.findByName(name).orElseThrow(()->new ResourceNotFound("El nombre de la carrera: "+name+" no fue encontrada"));
            dao.deleteByName(name);
    }

    @Override
    public CarreraDTO findById(Integer id) {
        Carrera carrera = dao.findById(id).orElseThrow(()->new ResourceNotFound("El id de la carrera: "+id+" no fue encontrada"));
            return Mapper.toDTO(carrera);
    }

    @Override
    public CarreraDTO findByName(String name) {
        Carrera carrera = dao.findByName(name).orElseThrow(()->new ResourceNotFound("El nombre de la carrera: "+name+" no fue encontrada"));
            return Mapper.toDTO(carrera);
    }

    @Override
    public List<CarreraDTO> findByLevel(String level) {
        List<Carrera> carrera = dao.findByLevel(level).orElseThrow(()->new ResourceNotFound("El nivel : "+level+" de las carreras no fue encontrado"));
            return carrera.stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<CarreraDTO> findByDuration(Float duration) {
        List<Carrera> carrera = dao.findByDuration(duration).orElseThrow(()->new ResourceNotFound("La duracion: "+duration+" de las carreras no fue encontrado"));
            return carrera.stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<CarreraDTO> findAll() {
        return dao.findAll().stream().map(Mapper::toDTO).toList();
    }
}
