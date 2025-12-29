package com.codefs.SistemaEscolar.dao;

import com.codefs.SistemaEscolar.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PersonaDAO extends JpaRepository<Persona, UUID> {
}
