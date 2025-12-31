package com.codefs.SistemaEscolar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse notFound(ResourceNotFound e){
        ExceptionResponse res = new ExceptionResponse(
                "Recurso no encontrado",
                HttpStatusCode.valueOf(404).toString(),
                LocalDate.now(),
                e.getMessage()
        );
        return res;
    }

}
