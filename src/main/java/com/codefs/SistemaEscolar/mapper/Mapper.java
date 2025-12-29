package com.codefs.SistemaEscolar.mapper;

import com.codefs.SistemaEscolar.dto.*;
import com.codefs.SistemaEscolar.model.*;

import javax.print.Doc;

public class Mapper {

    //Materia
    public static MateriaDTO toDTO(Materia materia){
        MateriaDTO materiaDTO = new MateriaDTO(
                materia.getId(),
                materia.getNombre(),
                materia.getCreditos(),
                materia.getParciales(),
                materia.getHoras(),
                materia.getSemestre(),
                materia.getInscripciones().stream().map(Mapper::toDTO).toList(),
                materia.getCarrera().getId(),
                materia.getDocente().getId()
        );
        return materiaDTO;
    }

    //Inscripción
    public static InscripcionDTO toDTO(Inscripcion inscripcion){
        InscripcionDTO inscripcionDTO = new InscripcionDTO(
                inscripcion.getId(),
                inscripcion.getFechaInscripcion(),
                inscripcion.getCicloEscolar(),
                inscripcion.getAlumno().getId(),
                inscripcion.getGrupo().getId(),
                inscripcion.getMateria().getId(),
                inscripcion.getCalificaciones().stream().map(Mapper::toDTO).toList()
        );
        return inscripcionDTO;
    }

    //Calificación
    public static CalificacionDTO toDTO(Calificacion calificacion){
        CalificacionDTO calificacionDTO = new CalificacionDTO(
                calificacion.getId(),
                calificacion.getParcial(),
                calificacion.getCalificacionFinal(),
                calificacion.getEstatus(),
                calificacion.getInscripcion().getId()
        );
        return calificacionDTO;
    }

    //Grupo
    public static GrupoDTO toDTO(Grupo grupo) {
        GrupoDTO grupoDTO = new GrupoDTO(
                grupo.getId(),
                grupo.getNombre(),
                grupo.getCicloEscolar(),
                grupo.getSemestre(),
                grupo.getTurno()
        );
        return grupoDTO;
    }

    //Carrera
    public static CarreraDTO toDTO(Carrera carrera){
        CarreraDTO carreraDTO = new CarreraDTO(
                carrera.getId(),
                carrera.getNombre(),
                carrera.getNivel(),
                carrera.getDuracion(),
                carrera.getMaterias().stream().map(Mapper::toDTO).toList()
        );
        return carreraDTO;
    }

    //Docente
    public static DocenteDTO toDTO(Docente docente){
        DocenteDTO docenteDTO = new DocenteDTO(
                docente.getId(),
                docente.getNombre(),
                docente.getApellidoPaterno(),
                docente.getApellidoMaterno(),
                docente.getDireccion(),
                docente.getSexo(),
                docente.getFechaNacimiento(),
                docente.getCorreo(),
                docente.getTelefono(),
                docente.getEstatus(),
                docente.getEspecialidad()
        );
        return docenteDTO;
    }

    //Alumno
    public static AlumnoDTO toDTO(Alumno alumno){
        AlumnoDTO alumnoDTO = new AlumnoDTO(
                alumno.getId(),
                alumno.getNombre(),
                alumno.getApellidoPaterno(),
                alumno.getApellidoMaterno(),
                alumno.getDireccion(),
                alumno.getSexo(),
                alumno.getFechaNacimiento(),
                alumno.getCorreo(),
                alumno.getTelefono(),
                alumno.getEstatus(),
                alumno.getMatricula()
        );
        return alumnoDTO;
    }
}
