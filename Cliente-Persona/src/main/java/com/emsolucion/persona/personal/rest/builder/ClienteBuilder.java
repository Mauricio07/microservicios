package com.emsolucion.persona.personal.rest.builder;

import com.emsolucion.persona.personal.database.models.Cliente;
import com.emsolucion.persona.personal.rest.dto.ClienteDto;
import org.springframework.stereotype.Component;

@Component
public class ClienteBuilder {

    public ClienteDto builder(Cliente model) {
        return ClienteDto.builder()
                .nombre(model.getNombre())
                .clienteId(model.getClienteId())
                .direccion(model.getDireccion())
                .identificacion(model.getIdentificacion())
                .telefono(model.getTelefono())
                .edad(model.getEdad())
                .genero(model.getGenero())
                .contrasenia(model.getContrasenia())
                .estado(model.getEstado())
                .build();
    }

    public Cliente builder(ClienteDto model) {
        return Cliente.builder()
                .nombre(model.getNombre())
                .clienteId(model.getClienteId())
                .direccion(model.getDireccion())
                .identificacion(model.getIdentificacion())
                .telefono(model.getTelefono())
                .edad(model.getEdad())
                .genero(model.getGenero())
                .contrasenia(model.getContrasenia())
                .estado(model.getEstado())
                .build();
    }

    public Cliente builderUpdate(Cliente cliente, ClienteDto model) {
        return Cliente.builder()
                .id(cliente.getId())
                .clienteId(cliente.getClienteId())
                .nombre(model.getNombre())
                .direccion(model.getDireccion())
                .identificacion(model.getIdentificacion())
                .telefono(model.getTelefono())
                .edad(model.getEdad())
                .genero(model.getGenero())
                .contrasenia(model.getContrasenia())
                .estado(model.getEstado())
                .build();
    }
}
