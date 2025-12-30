package com.codefs.SistemaEscolar.dao;

import com.codefs.SistemaEscolar.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MateriaDAO extends JpaRepository<Materia, UUID> {
    @Query(name = "Materia.findByNameAndMajorId")
    public Optional<Materia> findByNameAndMajorId(@Param("nombre") String name,@Param("id_career") Integer id_career);
    @Modifying
    @Query(name = "Materia.deleteByNameAndMajorId")
    public void deleteByNameAndMajorId(@Param("nombre") String name,@Param("id_career") Integer id_career);
    @Query(name = "Materia.findByName")
    public Optional<List<Materia>> findByName(@Param("nombre") String name);
    @Query(name = "Materia.findByPartial")
    public Optional<List<Materia>> findByPartial(@Param("parciales") Byte partial);
    @Query(name = "Materia.findByHours")
    public Optional<List<Materia>> findByHours(@Param("horas") Float hours);
    @Query(name = "Materia.finBySemester")
    public Optional<List<Materia>> findBySemester(@Param("semestre") Byte semester);
    @Query(name = "Materia.findByCareerId")
    public Optional<List<Materia>> findByCareerId(@Param("id_career") Integer id_career);
}
