package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dto.CarreraDTO;
import com.codefs.SistemaEscolar.model.Carrera;

import java.util.List;
import java.util.UUID;

public interface ICarrera {
    /*
        crear
        actualizar
            id
            nombre
        eliminar
            id
            nombre
            nivel -> no recomendado porque eliminar casi todas
        buscar
            id
            nombre
            nivel
            duracion
            todos
    */

    public CarreraDTO save(CarreraDTO carreraDTO);


    public CarreraDTO updateById(Integer id, CarreraDTO carreraDTO);
    public CarreraDTO updateByName(String name, CarreraDTO carreraDTO);


    public void deleteById(Integer id);
    public void deleteByName(String name);

    public CarreraDTO findById(Integer id);
    public CarreraDTO findByName(String name);
    public List<CarreraDTO> findByLevel(String level);
    public List<CarreraDTO> findByDuration(Float duration);
    public List<CarreraDTO> findAll();
}
