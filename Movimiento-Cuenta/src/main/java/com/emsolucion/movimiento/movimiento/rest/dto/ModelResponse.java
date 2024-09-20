package com.emsolucion.movimiento.movimiento.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModelResponse {
    private HttpStatus statusCode;
    private Object body;
    private String message;
}
