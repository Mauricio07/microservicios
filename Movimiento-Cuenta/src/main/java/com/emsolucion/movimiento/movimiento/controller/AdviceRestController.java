package com.emsolucion.movimiento.movimiento.controller;

import com.emsolucion.movimiento.movimiento.rest.dto.ModelResponse;
import com.emsolucion.movimiento.movimiento.services.exceptions.MovimientoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceRestController {

    @ExceptionHandler(value = MovimientoException.class)
    public ModelResponse handleAplicacion(MovimientoException exception) {
        return ModelResponse.builder()
                .statusCode(HttpStatus.NOT_ACCEPTABLE)
                .message(exception.getMessage())
                .build();
    }
}
