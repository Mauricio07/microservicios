package com.emsolucion.movimiento.movimiento.services.operators;

import com.emsolucion.movimiento.movimiento.feign.IPersonaFeign;
import com.emsolucion.movimiento.movimiento.rest.dto.ClienteDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService {

    private final IPersonaFeign personaService;

    public ClienteDto getClienteById(Long clienteId) {
        try {
            return personaService.getClienteById(clienteId);
        } catch (Exception e) {
            return ClienteDto.builder()
                    .id(clienteId).build();
        }
    }

}
