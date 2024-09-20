package com.emsolucion.persona.personal.rest.builder;

import com.emsolucion.persona.personal.database.models.Persona;
import com.emsolucion.persona.personal.rest.dto.PersonaDto;
import org.springframework.stereotype.Component;

@Component
public class PersonaBuilder {

    public PersonaDto builder(Persona model) {
        return PersonaDto.builder()
                .id(model.getId())
                .nombre(model.getNombre())
                .identificacion(model.getIdentificacion())
                .direccion(model.getDireccion())
                .telefono(model.getTelefono())
                .genero(model.getGenero())
                .edad(model.getEdad())
                .build();
    }

    public Persona builder(PersonaDto model) {
        return Persona.builder()
                .id(model.getId())
                .nombre(model.getNombre())
                .identificacion(model.getIdentificacion())
                .direccion(model.getDireccion())
                .telefono(model.getTelefono())
                .genero(model.getGenero())
                .edad(model.getEdad())
                .build();
    }


    public Persona builderUpdate(Persona persona, PersonaDto model) {
        return Persona.builder()
                .id(persona.getId())
                .nombre(model.getNombre())
                .identificacion(model.getIdentificacion())
                .direccion(model.getDireccion())
                .telefono(model.getTelefono())
                .genero(model.getGenero())
                .edad(model.getEdad())
                .build();
    }
}
