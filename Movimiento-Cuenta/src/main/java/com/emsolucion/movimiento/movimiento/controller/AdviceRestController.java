package com.emsolucion.movimiento.movimiento.controller;

import com.emsolucion.movimiento.movimiento.rest.dto.ModelResponse;
import com.emsolucion.movimiento.movimiento.services.exceptions.MovimientoException;
import com.emsolucion.movimiento.movimiento.services.messages.MensajesGlobales;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestControllerAdvice
public class AdviceRestController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = MovimientoException.class)
    public ModelResponse handleAplicacion(MovimientoException exception) {
        return ModelResponse.builder()
                .statusCode(HttpStatus.NOT_ACCEPTABLE)
                .message(exception.getMessage())
                .build();
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        return new ResponseEntity<>(ModelResponse.builder()
                .statusCode(HttpStatus.BAD_REQUEST)
                .message(MensajesGlobales.ERR_MSG_VALIDACIONES + " " + String.join(", ", errors))
                .build(), HttpStatus.OK);
    }
}
