package com.emsolucion.movimiento.movimiento.feign;

import com.emsolucion.movimiento.movimiento.rest.dto.ClienteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "SERVICE-PERSONA", url = "${service.gateway.url}")
public interface IPersonaFeign {

    @GetMapping("/api/service-persona/cliente/micro/findById")
    ClienteDto getClienteById(@RequestParam Long id) throws Exception;
}
