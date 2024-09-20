package com.emsolucion.persona.personal.rest.dto;

import com.emsolucion.persona.personal.rest.enums.TypeGeneroEnum;
import com.emsolucion.persona.personal.services.messages.MensajesGlobales;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto implements Serializable {

    private Long id;
    @NotNull(message = MensajesGlobales.MSG_ERROR_NOMBRE_INVALIDO)
    private String nombre;
    @NotNull(message = MensajesGlobales.MSG_ERROR_IDENTIFICACION_INVALIDO)
    private String identificacion;
    @NotNull(message = MensajesGlobales.MSG_ERROR_DIRECCION_INVALIDO)
    private String direccion;

    private String telefono;

    private TypeGeneroEnum genero;

    private Integer edad;
}
