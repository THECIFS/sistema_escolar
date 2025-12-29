package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dto.DocenteDTO;
import com.codefs.SistemaEscolar.model.Docente;

import java.util.List;
import java.util.UUID;

public interface IDocente {
        /*
        crear
        actualizar
            id
            correo
        eliminar:
            id
            correo
        buscar
            id
            correo
            telefono
            direccion
            estatus
            sexo
            especialidad
            todos
    */


    public DocenteDTO save(DocenteDTO docenteDTO);


    public DocenteDTO updateById(UUID id, DocenteDTO docenteDTO);
    public DocenteDTO updateByEmail(String email, DocenteDTO docenteDTO);

    public void deleteById(UUID id);
    public void deleteByEmail(String email);

    public DocenteDTO findById(UUID id);
    public DocenteDTO findByEmail(String email);
    public DocenteDTO findByPhone(String phone);
    public List<DocenteDTO> findByAddress(String address);
    public List<DocenteDTO> findByStatus(Boolean status);
    public List<DocenteDTO> findBySex(Character sex);
    public List<DocenteDTO> findBySpecialty(String specialty);
    public List<DocenteDTO> findAll();
}
