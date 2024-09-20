package com.emsolucion.movimiento.movimiento.rest.dto;

import com.emsolucion.movimiento.movimiento.rest.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto implements Serializable {

    private Long clienteId;
    private String contrasenia;
    private StatusEnum estado;
    private Long id;
    private String nombre;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String genero;
    private Integer edad;
}
