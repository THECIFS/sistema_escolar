package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dto.CalificacionDTO;
import com.codefs.SistemaEscolar.model.Calificacion;

import java.util.List;
import java.util.UUID;

public interface ICalificacion {
    /*
        crear
        actualizar
            id
        eliminar
            id
        buscar
            id
            parcial
            estatus
            id_inscripcion
    */

    public CalificacionDTO save(CalificacionDTO calificacionDTO);


    public CalificacionDTO updateById(UUID id, CalificacionDTO calificacionDTO);


    public void deleteById(UUID id);


    public CalificacionDTO findById(UUID id);
    public List<CalificacionDTO> findByPartial(Byte partial, UUID id);
    public List<CalificacionDTO> findByStatus(Boolean status, UUID id);
    public List<CalificacionDTO> findByRegistrationId(UUID registrationId);
    public List<CalificacionDTO> findAll();
}
