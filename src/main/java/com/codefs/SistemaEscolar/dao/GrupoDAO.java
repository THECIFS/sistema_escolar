package com.codefs.SistemaEscolar.dao;

import com.codefs.SistemaEscolar.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface GrupoDAO extends JpaRepository<Grupo, UUID> {
    @Query(name = "Grupo.findByName")
    public List<Grupo> findByName(@Param("nombre") String name);
    @Query(name = "Grupo.findBySchoolYear")
    public List<Grupo> findBySchoolYear(@Param("cicloEscolar") String schoolYear);
    @Query(name = "Grupo.findBySemester")
    public List<Grupo> findBySemester(@Param("semestre") Byte semester);
    @Query(name = "Grupo.findByShift")
    public List<Grupo> findByShift(@Param("turno") String shift);
}
