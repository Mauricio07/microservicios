package com.emsolucion.persona.personal.rest.dto;

import com.emsolucion.persona.personal.rest.enums.StatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ClienteDto extends PersonaDto implements Serializable {

    private Long clienteId;
    private String contrasenia;
    private StatusEnum estado;
}
