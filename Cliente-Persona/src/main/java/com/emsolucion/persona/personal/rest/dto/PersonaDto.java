package com.emsolucion.persona.personal.rest.dto;

import com.emsolucion.persona.personal.rest.enums.TypeGeneroEnum;
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
    private String nombre;
    private String identificacion;
    private String direccion;
    private String telefono;
    private TypeGeneroEnum genero;
    private Integer edad;
}
