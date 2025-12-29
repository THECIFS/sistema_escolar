package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dao.CalificacionDAO;
import com.codefs.SistemaEscolar.dao.InscripcionDAO;
import com.codefs.SistemaEscolar.dto.CalificacionDTO;
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
        if(calificacionDTO!=null){

            Inscripcion inscripcion = inscripcionDAO.findById(calificacionDTO.id_inscripcion()).orElse(null);

            if(inscripcion!=null){
                Calificacion calificacion = Calificacion.builder()
                        .parcial(calificacionDTO.parcial())
                        .calificacionFinal(calificacionDTO.calificacionFinal())
                        .estatus(calificacionDTO.estatus())
                        .inscripcion(inscripcion)
                        .build();

                return Mapper.toDTO(calificacionDAO.save(calificacion));
            }

            return null;
        }
        return null;
    }

    @Override
    public CalificacionDTO updateById(UUID id, CalificacionDTO calificacionDTO) {
        Calificacion calificacion = calificacionDAO.findById(id).orElse(null);
        if(calificacion!=null){
            calificacion.setParcial(calificacionDTO.parcial());
            calificacion.setCalificacionFinal(calificacion.getCalificacionFinal());
            calificacion.setEstatus(calificacion.getEstatus());

            if(calificacionDTO.id_inscripcion()!=null){
                Inscripcion inscripcion = inscripcionDAO.findById(calificacionDTO.id_inscripcion()).orElse(null);
                calificacion.setInscripcion(inscripcion);
            }
        }
        return null;
    }

    @Override
    public void deleteById(UUID id) {
        Calificacion calificacion = calificacionDAO.findById(id).orElse(null);
        if(calificacion!=null){
            calificacionDAO.deleteById(id);
        }
        //throw new RuntimeException("");
    }

    @Override
    public CalificacionDTO findById(UUID id) {
        return Mapper.toDTO(calificacionDAO.findById(id).orElseThrow(()->{throw new RuntimeException("");}));
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
