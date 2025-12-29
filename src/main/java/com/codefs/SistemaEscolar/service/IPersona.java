package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dto.PersonaDTO;
import com.codefs.SistemaEscolar.model.Persona;
import jakarta.el.ELException;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IPersona {
    /*
        crear
        actualizar
            id
            correo
        eliminar
            id
            correo
        buscar
            id
            direccion
            sexo
            fechaNacimiento
            correo
            telefono
            estatus
    */

    public PersonaDTO save(PersonaDTO personaDTO);


    public PersonaDTO updateById(UUID id, PersonaDTO personaDTO);
    public PersonaDTO updateByEmail(String email, PersonaDTO personaDTO);


    public void deleteById(UUID id);
    public void deleteByEmail(String email);


    public PersonaDTO findById(UUID id);
    public List<PersonaDTO> findByAddress(String address);
    public List<PersonaDTO> findBySex(Character sex);
    public List<PersonaDTO> findByDate(LocalDate date);
    public PersonaDTO findByEmail(String email);
    public List<PersonaDTO> findByPhone(String phone);
    public List<PersonaDTO> findByStatus(Boolean status);


}
