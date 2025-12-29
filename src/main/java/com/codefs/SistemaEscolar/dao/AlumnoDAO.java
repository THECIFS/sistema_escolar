package com.codefs.SistemaEscolar.dao;

import com.codefs.SistemaEscolar.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AlumnoDAO extends JpaRepository<Alumno, UUID> {

    @Query(name = "Alumno.findByEmail")
    public Optional<Alumno> findByEmail(@Param("correo") String email);

    @Query(name = "Alumno.findByEnrollment")
    public Optional<Alumno> findByEnrollment(@Param("matricula") String enrollment);

    @Query(name = "Alumno.findByPhone")
    public Optional<Alumno> findByPhone(@Param("telefono") String phone);

    @Query(name = "Alumno.findByAddress")
    public Optional<Alumno> findByAddress(@Param("direccion") String address);

    @Query(name = "Alumno.findByStatus")
    public Optional<Alumno> findByStatus(@Param("estatus") Boolean estatus);

    @Query(name = "Alumno.findBySex")
    public Optional<Alumno> findBySex(@Param("sexo") Character sexo);

    @Modifying
    @Query(name = "Alumno.deleteByEmail")
    public void deleteByEmail(@Param("correo") String email);

    @Modifying
    @Query(name = "Alumno.deleteByEnrollment")
    public void deleteByEnrollment(@Param("matricula") String matricula);

}
