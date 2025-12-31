package com.codefs.SistemaEscolar.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class ExceptionResponse {
    String message;
    String httpStatusCode;
    LocalDate timesTamp;
    String details;
}
