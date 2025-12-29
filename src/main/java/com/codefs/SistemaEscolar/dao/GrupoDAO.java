package com.codefs.SistemaEscolar.dao;

import com.codefs.SistemaEscolar.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GrupoDAO extends JpaRepository<Grupo, UUID> {
}
