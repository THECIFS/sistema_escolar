package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dto.AlumnoDTO;

import java.util.List;
import java.util.UUID;

public interface IAlumno{
    /*
        crear
        actualizar
            id
            correo
            matricula
        eliminar:
            id
            correo
            matricula
        buscar
            id
            correo
            telefono
            direccion
            estatus
            sexo
            matricula
            todos
    */


    public AlumnoDTO save(AlumnoDTO alumnoDTO);


    public AlumnoDTO updateById(UUID id, AlumnoDTO alumnoDTO);
    public AlumnoDTO updateByEmail(String email, AlumnoDTO alumnoDTO);
    public AlumnoDTO updateByEnrollment(String enrollment, AlumnoDTO alumnoDTO);


    public void deleteById(UUID id);
    public void deleteByEmail(String email);
    public void deleteByEnrollment(String enrollment);


    public AlumnoDTO findById(UUID id);
    public AlumnoDTO findByEmail(String email);
    public AlumnoDTO findByPhone(String phone);
    public List<AlumnoDTO> findByAddress(String address);
    public List<AlumnoDTO> findByStatus(Boolean status);
    public List<AlumnoDTO> findBySex(Character sex);
    public AlumnoDTO findByEnrollment(String enrollment);
    public List<AlumnoDTO> findAll();
}
