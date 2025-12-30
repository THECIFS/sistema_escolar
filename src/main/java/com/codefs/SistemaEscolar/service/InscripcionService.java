package com.codefs.SistemaEscolar.service;

import com.codefs.SistemaEscolar.dao.InscripcionDAO;
import com.codefs.SistemaEscolar.dto.InscripcionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class InscripcionService implements IInscripcion{

    @Autowired
    private InscripcionDAO dao;


    @Override
    public InscripcionDTO save(InscripcionDTO inscripcionDTO) {
        return null;
    }

    @Override
    public InscripcionDTO updateById(UUID id, InscripcionDTO inscripcionDTO) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public InscripcionDTO findById(UUID id) {
        return null;
    }

    @Override
    public List<InscripcionDTO> findByDate(LocalDate date) {
        return List.of();
    }

    @Override
    public List<InscripcionDTO> findBySchoolYear(String schoolYear) {
        return List.of();
    }

    @Override
    public List<InscripcionDTO> findByStudentId(UUID id) {
        return List.of();
    }

    @Override
    public List<InscripcionDTO> findByGroupId(UUID id) {
        return List.of();
    }

    @Override
    public List<InscripcionDTO> findBySubjectId(UUID id) {
        return List.of();
    }

    @Override
    public List<InscripcionDTO> findByTeachingId(UUID id) {
        return List.of();
    }

    @Override
    public List<InscripcionDTO> findAll() {
        return List.of();
    }
}
