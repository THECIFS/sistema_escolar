package com.codefs.SistemaEscolar.dao;

import com.codefs.SistemaEscolar.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InscripcionDAO extends JpaRepository<Inscripcion, UUID> {
}
