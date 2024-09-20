package com.emsolucion.movimiento.movimiento.rest.builder;

import com.emsolucion.movimiento.movimiento.database.models.Cuenta;
import com.emsolucion.movimiento.movimiento.rest.dto.CuentaDto;
import org.springframework.stereotype.Component;

@Component
public class CuentaBuilder {

    public CuentaDto builder(Cuenta model) {
        return CuentaDto.builder()
                .id(model.getId())
                .numero(model.getNumero())
                .tipo(model.getTipo())
                .saldoInicial(model.getSaldoInicial())
                .estado(model.getEstado())
                .build();
    }

    public Cuenta builder(CuentaDto model) {
        return Cuenta.builder()
                .id(model.getId())
                .numero(model.getNumero())
                .tipo(model.getTipo())
                .saldoInicial(model.getSaldoInicial())
                .estado(model.getEstado())
                .build();
    }

    public Cuenta builderUpdate(Cuenta cuenta, CuentaDto model) {
        return Cuenta.builder()
                .id(cuenta.getId())
                .numero(model.getNumero())
                .tipo(model.getTipo())
                .saldoInicial(model.getSaldoInicial())
                .estado(model.getEstado())
                .build();
    }
}
