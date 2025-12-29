package com.codefs.SistemaEscolar.dao;

import com.codefs.SistemaEscolar.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarreraDAO extends JpaRepository<Carrera, Integer> {

    @Query(name = "Carrera.findpByName")
    public Optional<Carrera> findByName(@Param("nombre") String name);

    @Modifying
    @Query(name = "Carrera.deleteByName")
    public void deleteByName(@Param("nombre") String name);

    @Query(name = "Carrera.findByLevel")
    public Optional<List<Carrera>> findByLevel(@Param("nivel") String level);

    @Query(name = "Carrera.findByDuration")
    public Optional<List<Carrera>> findByDuration(@Param("duracion") Float duration);
}
