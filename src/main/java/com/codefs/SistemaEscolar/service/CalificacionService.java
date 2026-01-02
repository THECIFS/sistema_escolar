package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dao.CalificacionDAO;
import com.codefs.SistemaEscolar.dao.InscripcionDAO;
import com.codefs.SistemaEscolar.dto.CalificacionDTO;
import com.codefs.SistemaEscolar.exception.ResourceNotFound;
import com.codefs.SistemaEscolar.mapper.Mapper;
import com.codefs.SistemaEscolar.model.Calificacion;
import com.codefs.SistemaEscolar.model.Inscripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CalificacionService implements ICalificacion{

    @Autowired
    private CalificacionDAO calificacionDAO;


    @Autowired
    private InscripcionDAO inscripcionDAO;

    @Override
    public CalificacionDTO save(CalificacionDTO calificacionDTO) {
            Inscripcion inscripcion = inscripcionDAO.findById(calificacionDTO.id_inscripcion()).orElseThrow(()->new ResourceNotFound("La ID de la inscripcion: "+calificacionDTO.id_inscripcion()+" no fue encontrada"));
                Calificacion calificacion = Calificacion.builder()
                        .parcial(calificacionDTO.parcial())
                        .calificacionFinal(calificacionDTO.calificacionFinal())
                        .estatus(calificacionDTO.estatus())
                        .inscripcion(inscripcion)
                        .build();
                return Mapper.toDTO(calificacionDAO.save(calificacion));
    }

    @Override
    public CalificacionDTO updateById(UUID id, CalificacionDTO calificacionDTO) {
        Calificacion calificacion = calificacionDAO.findById(id).orElseThrow(()->new ResourceNotFound("El id de la calificacion: "+id+" no fue encontrada"));
            calificacion.setParcial(calificacionDTO.parcial());
            calificacion.setCalificacionFinal(calificacion.getCalificacionFinal());
            calificacion.setEstatus(calificacionDTO.estatus());
                Inscripcion inscripcion = inscripcionDAO.findById(calificacionDTO.id_inscripcion()).orElseThrow(()->new ResourceNotFound("El id de la inscripcion: "+calificacionDTO.id_inscripcion()+"no fue encontrada"));
                calificacion.setInscripcion(inscripcion);
            return Mapper.toDTO(calificacionDAO.save(calificacion));
    }

    @Override
    public void deleteById(UUID id) {
        Calificacion calificacion = calificacionDAO.findById(id).orElseThrow(()->new ResourceNotFound("El id de la calificacion: "+id+" no fue encontrada"));
            calificacionDAO.deleteById(id);
    }

    @Override
    public CalificacionDTO findById(UUID id) {
        return Mapper.toDTO(calificacionDAO.findById(id).orElseThrow(()->new ResourceNotFound("El id de la calificacion:"+id+" no fue encontrada")));
    }

    @Override
    public List<CalificacionDTO> findByPartial(Byte partial, UUID id) {
        return calificacionDAO.findByPartial(partial, id).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<CalificacionDTO> findByStatus(Boolean status, UUID id) {
        return calificacionDAO.findByStatus(status, id).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<CalificacionDTO> findByRegistrationId(UUID registrationId) {
        return calificacionDAO.findByRegistrationId(registrationId).stream().map(Mapper::toDTO).toList();
    }

    @Override
    public List<CalificacionDTO> findAll() {
        return calificacionDAO.findAll().stream().map(Mapper::toDTO).toList();
    }
}
