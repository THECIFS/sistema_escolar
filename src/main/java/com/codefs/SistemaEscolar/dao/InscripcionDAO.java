package com.codefs.SistemaEscolar.dao;

import com.codefs.SistemaEscolar.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface InscripcionDAO extends JpaRepository<Inscripcion, UUID> {
    @Query(name = "Inscripcion.findByDate")
    public List<Inscripcion> findByDate(@Param("fechaInscripcion") LocalDate date);
    @Query(name = "Inscripcion.findBySchoolYear")
    public List<Inscripcion> findBySchoolYear(@Param("cicloEscolar") String schoolYear);
    @Query(name = "Inscripcion.findByStudentId")
    public List<Inscripcion> findByStudentId(@Param("id_alumno") UUID student_id);
    @Query(name = "Inscripcion.findByGroupId")
    public List<Inscripcion> findByGroupId(@Param("id_grupo") UUID group_id);
    @Query(name = "Inscripcion.findBySubjectId")
    public List<Inscripcion> findBySubjectId(@Param("id_materia") UUID subject_id);
    @Query(name = "Inscripcion.findByTeachingId")
    public List<Inscripcion> findByTeachingId(@Param("id_docente") UUID teaching_id);

}
