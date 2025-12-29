package com.codefs.SistemaEscolar.dao;

import com.codefs.SistemaEscolar.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DocenteDAO extends JpaRepository<Docente, UUID> {

    @Query(name = "Docente.findByEmail")
    public Optional<Docente> findByEmail(@Param("correo") String email);

    @Modifying
    @Query(name = "Docente.deleteByEmail")
    public void deleteByEmail(@Param("correo") String email);

    @Query(name = "Docente.findByPhone")
    public Optional<Docente> findByPhone(@Param("telefono") String phone);

    @Query(name = "Docente.findByAddress")
    public List<Docente> findByAddress(@Param("direccion") String address);

    @Query(name = "Docente.findByStatus")
    public List<Docente> findByStatus(@Param("estatus") Boolean status);

    @Query(name = "Docente.findBySex")
    public List<Docente> findBySex(@Param("sexo") Character sex);

    @Query(name = "Docente.findBySpecialty")
    public List<Docente> findBySpecialty(@Param("especialidad") String especialidad);
}
