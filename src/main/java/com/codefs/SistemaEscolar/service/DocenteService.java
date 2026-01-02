package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dao.DocenteDAO;
import com.codefs.SistemaEscolar.dto.DocenteDTO;
import com.codefs.SistemaEscolar.exception.ResourceNotFound;
import com.codefs.SistemaEscolar.mapper.Mapper;
import com.codefs.SistemaEscolar.model.Docente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DocenteService implements IDocente{

    @Autowired
    private DocenteDAO dao;

    @Override
    public DocenteDTO save(DocenteDTO docenteDTO) {
            Docente docente = Docente.builder()
                    .nombre(docenteDTO.nombre())
                    .apellidoPaterno(docenteDTO.apellidoPaterno())
                    .apellidoMaterno(docenteDTO.apellidoMaterno())
                    .direccion(docenteDTO.direccion())
                    .sexo(docenteDTO.sexo())
                    .fechaNacimiento(docenteDTO.fechaNacimiento())
                    .correo(docenteDTO.correo())
                    .telefono(docenteDTO.telefono())
                    .estatus(true)
                    .especialidad(docenteDTO.especialidad())
                    .inscripciones(new ArrayList<>())
                    .build();
            return Mapper.toDTO(dao.save(docente));
    }

    @Transactional
    @Override
    public DocenteDTO updateById(UUID id, DocenteDTO docenteDTO) {
        Docente docente = dao.findById(id).orElseThrow(()->new ResourceNotFound("El id del docente: "+id+" no fue encontrada"));
            docente.setNombre(docenteDTO.nombre());
            docente.setApellidoPaterno(docenteDTO.apellidoPaterno());
            docente.setApellidoMaterno(docenteDTO.apellidoMaterno());
            docente.setDireccion(docenteDTO.direccion());
            docente.setSexo(docenteDTO.sexo());
            docente.setFechaNacimiento(docenteDTO.fechaNacimiento());
            docente.setCorreo(docenteDTO.correo());
            docente.setTelefono(docenteDTO.telefono());
            docente.setEstatus(docenteDTO.estatus());
            Docente updateDocente = dao.save(docente);
            return Mapper.toDTO(updateDocente);
    }

    @Transactional
    @Override
    public DocenteDTO updateByEmail(String email, DocenteDTO docenteDTO) {
        Docente docente = dao.findByEmail(email).orElseThrow(()->new ResourceNotFound("El email del docene: "+email+" no fue encontrado"));
            docente.setNombre(docenteDTO.nombre());
            docente.setApellidoPaterno(docenteDTO.apellidoPaterno());
            docente.setApellidoMaterno(docenteDTO.apellidoMaterno());
            docente.setDireccion(docenteDTO.direccion());
            docente.setSexo(docenteDTO.sexo());
            docente.setFechaNacimiento(docenteDTO.fechaNacimiento());
            docente.setTelefono(docenteDTO.telefono());
            docente.setEstatus(docenteDTO.estatus());
            docente.setEspecialidad(docenteDTO.especialidad());
            Docente updateDocente = dao.save(docente);
            return Mapper.toDTO(updateDocente);
    }

    @Override
    public void deleteById(UUID id) {
        Docente docente = dao.findById(id).orElseThrow(()->new ResourceNotFound("El id del docente: "+id+" no fue encontrado"));
            dao.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteByEmail(String email) {
        Docente docente = dao.findByEmail(email).orElseThrow(()->new ResourceNotFound("El email del docene"+email+" no fue encontrado"));
            dao.deleteByEmail(email);
    }

    @Override
    public DocenteDTO findById(UUID id) {
        Docente docente = dao.findById(id).orElseThrow(()->new ResourceNotFound("El id del docente: "+id+" no fue encontrado"));
            return Mapper.toDTO(docente);
    }

    @Override
    public DocenteDTO findByEmail(String email) {
        Docente docente = dao.findByEmail(email).orElseThrow(()-> new ResourceNotFound("El email del docente: "+email+" no fue encontrado"));
            return Mapper.toDTO(docente);
    }

    @Override
    public DocenteDTO findByPhone(String phone) {
        Docente docente = dao.findByPhone(phone).orElseThrow(()->new ResourceNotFound("El telefono del docente: "+phone+" no fue encontrado"));
            return Mapper.toDTO(docente);
    }

    @Override
    public List<DocenteDTO> findByAddress(String address) {
        return dao.findByAddress(address).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<DocenteDTO> findByStatus(Boolean status) {
        return dao.findByStatus(status).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<DocenteDTO> findBySex(Character sex) {
        return dao.findBySex(sex).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<DocenteDTO> findBySpecialty(String specialty) {
        return dao.findBySpecialty(specialty).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<DocenteDTO> findAll() {
        return dao.findAll().stream().map(Mapper::toDTO).toList();
    }
}
