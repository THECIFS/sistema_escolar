package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dao.CarreraDAO;
import com.codefs.SistemaEscolar.dao.MateriaDAO;
import com.codefs.SistemaEscolar.dto.CarreraDTO;
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
        if(carreraDTO!=null){
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
        return null;
    }

    @Transactional
    @Override
    public CarreraDTO updateById(Integer id, CarreraDTO carreraDTO) {
        Carrera carrera = dao.findById(id).orElse(null);
        if(carrera!=null){
            carrera.setNombre(carreraDTO.nombre());
            carrera.setNivel(carreraDTO.nivel());
            carrera.setDuracion(carreraDTO.duracion());
            return Mapper.toDTO(dao.save(carrera));
        }
        return null;
    }

    @Transactional
    @Override
    public CarreraDTO updateByName(String name, CarreraDTO carreraDTO) {

        Carrera carrera = dao.findByName(name).orElse(null);

        if(carrera!=null){

            carrera.setNivel(carreraDTO.nivel());
            carrera.setNivel(carreraDTO.nivel());

            return Mapper.toDTO(carrera);
        }

        return null;
    }

    @Override
    public void deleteById(Integer id) {
        Carrera carrera = dao.findById(id).orElse(null);
        if(carrera!=null){
            dao.deleteById(id);
        }
    }

    @Transactional
    @Override
    public void deleteByName(String name) {
        Carrera carrera = dao.findByName(name).orElse(null);
        if(carrera!=null){
            dao.deleteByName(name);
        }
    }

    @Override
    public CarreraDTO findById(Integer id) {
        Carrera carrera = dao.findById(id).orElse(null);
        if(carrera!=null){
            return Mapper.toDTO(carrera);
        }
        return null;
    }

    @Override
    public CarreraDTO findByName(String name) {
        Carrera carrera = dao.findByName(name).orElse(null);
        if(carrera!=null){
            return Mapper.toDTO(carrera);
        }
        return null;
    }

    @Override
    public List<CarreraDTO> findByLevel(String level) {
        List<Carrera> carrera = dao.findByLevel(level).orElse(null);
        if(carrera!=null){
            return carrera.stream().map(Mapper::toDTO).toList();
        }
        return List.of();
    }

    @Override
    public List<CarreraDTO> findByDuration(Float duration) {
        List<Carrera> carrera = dao.findByDuration(duration).orElse(null);
        if(carrera!=null){
            return carrera.stream().map(Mapper::toDTO).toList();
        }
        return List.of();
    }

    @Override
    public List<CarreraDTO> findAll() {
        return dao.findAll().stream().map(Mapper::toDTO).toList();
    }
}
