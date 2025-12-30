package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dao.DocenteDAO;
import com.codefs.SistemaEscolar.dto.DocenteDTO;
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
        if(docenteDTO!=null){
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
        return null;
    }

    @Transactional
    @Override
    public DocenteDTO updateById(UUID id, DocenteDTO docenteDTO) {
        Docente docente = dao.findById(id).orElse(null);
        if(docente!=null){
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
        return null;
    }

    @Transactional
    @Override
    public DocenteDTO updateByEmail(String email, DocenteDTO docenteDTO) {
        Docente docente = dao.findByEmail(email).orElse(null);
        if(docente!=null){
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
        return null;
    }

    @Override
    public void deleteById(UUID id) {
        Docente docente = dao.findById(id).orElse(null);
        if(docente!=null){
            dao.deleteById(id);
        }
        //throw new RuntimeException("");
    }

    @Transactional
    @Override
    public void deleteByEmail(String email) {
        Docente docente = dao.findByEmail(email).orElse(null);
        if(docente!=null){
            dao.deleteByEmail(email);
        }
        //throw new RuntimeException("");
    }

    @Override
    public DocenteDTO findById(UUID id) {
        Docente docente = dao.findById(id).orElse(null);
        if(docente!=null){
            return Mapper.toDTO(docente);
        }
        return null;
    }

    @Override
    public DocenteDTO findByEmail(String email) {
        Docente docente = dao.findByEmail(email).orElse(null);
        if(docente!=null){
            return Mapper.toDTO(docente);
        }
        return null;
    }

    @Override
    public DocenteDTO findByPhone(String phone) {
        Docente docente = dao.findByPhone(phone).orElse(null);
        if(docente!=null){
            return Mapper.toDTO(docente);
        }
        return null;
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
