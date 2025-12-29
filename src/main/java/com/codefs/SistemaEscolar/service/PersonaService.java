package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dao.PersonaDAO;
import com.codefs.SistemaEscolar.dto.PersonaDTO;
import com.codefs.SistemaEscolar.mapper.Mapper;
import com.codefs.SistemaEscolar.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PersonaService implements IPersona{

    @Autowired
    private PersonaDAO personaDAO;

    @Override
    public PersonaDTO save(PersonaDTO personaDTO){
        return null;
    }

    @Override
    public PersonaDTO updateById(UUID id, PersonaDTO personaDTO) {
        return null;
    }

    @Override
    public PersonaDTO updateByEmail(String email, PersonaDTO personaDTO) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public void deleteByEmail(String email) {

    }

    @Override
    public PersonaDTO findById(UUID id) {
        return null;
    }

    @Override
    public List<PersonaDTO> findByAddress(String address) {
        return List.of();
    }

    @Override
    public List<PersonaDTO> findBySex(Character sex) {
        return List.of();
    }

    @Override
    public List<PersonaDTO> findByDate(LocalDate date) {
        return List.of();
    }

    @Override
    public PersonaDTO findByEmail(String email) {
        return null;
    }

    @Override
    public List<PersonaDTO> findByPhone(String phone) {
        return List.of();
    }

    @Override
    public List<PersonaDTO> findByStatus(Boolean status) {
        return List.of();
    }
}
