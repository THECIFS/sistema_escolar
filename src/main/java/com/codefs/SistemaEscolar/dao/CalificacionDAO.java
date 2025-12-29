package com.codefs.SistemaEscolar.dao;

import com.codefs.SistemaEscolar.model.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CalificacionDAO extends JpaRepository<Calificacion, UUID> {

    @Query(name = "Calificacion.findByPartial")
    public List<Calificacion> findByPartial(@Param("parcial") Byte partial,@Param("id") UUID id);

    @Query(name = "Calificacion.findByStatus")
    public List<Calificacion> findByStatus(@Param("estatus") Boolean status,@Param("id") UUID id);

    @Query(name = "Calificacion.findByRegistrationId")
    public List<Calificacion> findByRegistrationId(@Param("id") UUID id);

}
