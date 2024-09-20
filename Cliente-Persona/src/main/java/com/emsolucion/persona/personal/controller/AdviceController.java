package com.emsolucion.persona.personal.controller;

import com.emsolucion.persona.personal.rest.dto.ModelResponse;
import com.emsolucion.persona.personal.services.exception.ApplicacionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(value = ApplicacionException.class)
    public ModelResponse handleAplicacion(ApplicacionException exception) {
        return ModelResponse.builder()
                .statusCode(HttpStatus.NOT_ACCEPTABLE)
                .message(exception.getMessage())
                .build();
    }

}
