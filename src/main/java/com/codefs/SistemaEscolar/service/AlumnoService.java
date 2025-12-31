package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dao.AlumnoDAO;
import com.codefs.SistemaEscolar.dto.AlumnoDTO;
import com.codefs.SistemaEscolar.exception.ResourceNotFound;
import com.codefs.SistemaEscolar.mapper.Mapper;
import com.codefs.SistemaEscolar.model.Alumno;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlumnoService implements IAlumno{

    @Autowired
    private AlumnoDAO dao;

    @Override
    public AlumnoDTO save(AlumnoDTO alumnoDTO) {
            Alumno alumno = Alumno.builder()
                    .nombre(alumnoDTO.nombre())
                    .apellidoPaterno(alumnoDTO.apellidoPaterno())
                    .apellidoMaterno(alumnoDTO.apellidoMaterno())
                    .direccion(alumnoDTO.direccion())
                    .sexo(alumnoDTO.sexo())
                    .fechaNacimiento(alumnoDTO.fechaNacimiento())
                    .correo(alumnoDTO.correo())
                    .telefono(alumnoDTO.telefono())
                    .estatus(true)
                    .matricula(alumnoDTO.matricula())
                    .build();
            return Mapper.toDTO(dao.save(alumno));
    }

    @Transactional(rollbackOn = RuntimeException.class)
    @Override
    public AlumnoDTO updateById(UUID id, AlumnoDTO alumnoDTO) {
        Alumno alumno = dao.findById(id).orElseThrow(()->new ResourceNotFound("La ID del alumno: "+id+" no fue encontrada"));
            alumno.setNombre(alumnoDTO.nombre());
            alumno.setApellidoPaterno(alumnoDTO.apellidoPaterno());
            alumno.setApellidoMaterno(alumnoDTO.apellidoMaterno());
            alumno.setDireccion(alumnoDTO.direccion());
            alumno.setSexo(alumnoDTO.sexo());
            alumno.setFechaNacimiento(alumnoDTO.fechaNacimiento());
            alumno.setCorreo(alumnoDTO.correo());
            alumno.setTelefono(alumnoDTO.telefono());
            alumno.setEstatus(alumnoDTO.estatus());
            alumno.setMatricula(alumnoDTO.matricula());
            Alumno alumnoUpdate = dao.save(alumno);
            return Mapper.toDTO(alumnoUpdate);
    }

    @Transactional
    @Override
    public AlumnoDTO updateByEmail(String email, AlumnoDTO alumnoDTO) {
        Alumno alumno = dao.findByEmail(email).orElseThrow(()->new ResourceNotFound("El correo del alumno: "+email+" no fue encontrado"));
            alumno.setNombre(alumnoDTO.nombre());
            alumno.setApellidoPaterno(alumnoDTO.apellidoPaterno());
            alumno.setApellidoMaterno(alumnoDTO.apellidoMaterno());
            alumno.setDireccion(alumnoDTO.direccion());
            alumno.setSexo(alumnoDTO.sexo());
            alumno.setFechaNacimiento(alumnoDTO.fechaNacimiento());
            alumno.setTelefono(alumnoDTO.telefono());
            alumno.setEstatus(alumnoDTO.estatus());
            alumno.setMatricula(alumnoDTO.matricula());
            Alumno alumnoUpdate = dao.save(alumno);
            return Mapper.toDTO(alumnoUpdate);
    }

    @Transactional
    @Override
    public AlumnoDTO updateByEnrollment(String enrollment, AlumnoDTO alumnoDTO) {
        Alumno alumno = dao.findByEnrollment(enrollment).orElseThrow(()->new ResourceNotFound("La matricula del alumno: "+enrollment+" no fue encontrada"));
            alumno.setNombre(alumnoDTO.nombre());
            alumno.setApellidoPaterno(alumnoDTO.apellidoPaterno());
            alumno.setApellidoMaterno(alumnoDTO.apellidoMaterno());
            alumno.setDireccion(alumnoDTO.direccion());
            alumno.setSexo(alumnoDTO.sexo());
            alumno.setFechaNacimiento(alumnoDTO.fechaNacimiento());
            alumno.setCorreo(alumnoDTO.correo());
            alumno.setTelefono(alumnoDTO.telefono());
            alumno.setEstatus(alumnoDTO.estatus());
            Alumno alumnoUpdate = dao.save(alumno);
            return Mapper.toDTO(alumnoUpdate);
    }

    @Transactional
    @Override
    public void deleteById(UUID id) {
        Alumno alumno = dao.findById(id).orElseThrow(()->new ResourceNotFound("La ID del alumno: "+id+" no fue encontrada"));
            dao.deleteById(alumno.getId());
    }

    @Transactional
    @Override
    public void deleteByEmail(String email) {
        Alumno alumno = dao.findByEmail(email).orElseThrow(()->new ResourceNotFound("El correo del alumno: "+email+" no fue encontrado"));
            dao.deleteByEmail(email);
    }

    @Transactional
    @Override
    public void deleteByEnrollment(String enrollment) {
        Alumno alumno = dao.findByEnrollment(enrollment).orElseThrow(()->new ResourceNotFound("La matricula del alumno: "+enrollment+" no fue encontrada"));
            dao.deleteByEnrollment(enrollment);
    }

    @Override
    public AlumnoDTO findById(UUID id) {
        return Mapper.toDTO(dao.findById(id).orElseThrow(()->{throw new ResourceNotFound("El ID del alumno: "+id+" no fue encontradp");}));
    }

    @Override
    public AlumnoDTO findByEmail(String email) {
        return Mapper.toDTO(dao.findByEmail(email).orElseThrow(()->{throw new ResourceNotFound("El correo del alumno: "+email+" no fue encontrado");}));
    }

    @Override
    public AlumnoDTO findByPhone(String phone) {
        return Mapper.toDTO(dao.findByPhone(phone).orElseThrow(()->{throw new RuntimeException("El numero de telefono del alumno: "+phone+" no fue encontrado");}));
    }

    @Override
    public List<AlumnoDTO> findByAddress(String address) {
        return dao.findByAddress(address).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<AlumnoDTO> findByStatus(Boolean status) {
        return dao.findByStatus(status).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<AlumnoDTO> findBySex(Character sex) {
        return dao.findBySex(sex).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public AlumnoDTO findByEnrollment(String enrollment) {
        return Mapper.toDTO(dao.findByEnrollment(enrollment).orElseThrow(()->{
            throw new ResourceNotFound("La matricula del alumno: "+enrollment+" no fue encontrada");
        }));
    }

    @Override
    public List<AlumnoDTO> findAll() {
        return dao.findAll().stream().map(Mapper::toDTO).toList();
    }
}
