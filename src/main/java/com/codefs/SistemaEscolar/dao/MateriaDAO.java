package com.codefs.SistemaEscolar.dao;

import com.codefs.SistemaEscolar.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MateriaDAO extends JpaRepository<Materia, UUID> {
}
