package com.emsolucion.movimiento.movimiento.rest.builder;

import com.emsolucion.movimiento.movimiento.database.models.Movimiento;
import com.emsolucion.movimiento.movimiento.rest.dto.CuentaDto;
import com.emsolucion.movimiento.movimiento.rest.dto.MovimientoDto;
import com.emsolucion.movimiento.movimiento.services.messages.MensajesGlobales;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MovimientoBuilder {

    private final CuentaBuilder cuentaBuilder;

    public MovimientoBuilder(CuentaBuilder cuentaBuilder) {
        this.cuentaBuilder = cuentaBuilder;
    }

    public MovimientoDto builder(Movimiento model) {
        return MovimientoDto.builder()
                .id(model.getId())
                .fecha(model.getFecha())
                .tipo(model.getTipo())
                .valor(model.getValor())
                .saldo(model.getSaldo())
                .observacion(model.getObservacion())
                .numeroCuenta(model.getCuenta().getNumero())
                .cuenta(cuentaBuilder.builder(model.getCuenta()))
                .build();
    }

    public Movimiento builder(MovimientoDto model) {
        return Movimiento.builder()
                .id(model.getId())
                .fecha(model.getFecha())
                .tipo(model.getTipo())
                .valor(model.getValor())
                .saldo(model.getSaldo())
                .observacion(model.getObservacion())
                .cuenta(cuentaBuilder.builder(model.getCuenta()))
                .build();
    }

    public Movimiento builderUpdate(Movimiento movimiento, MovimientoDto model) {
        return Movimiento.builder()
                .id(movimiento.getId())
                .cuenta(movimiento.getCuenta())
                .fecha(model.getFecha())
                .tipo(model.getTipo())
                .valor(model.getValor())
                .saldo(model.getSaldo())
                .observacion(model.getObservacion())
                .build();
    }

    public Movimiento builderCuenta(CuentaDto cuenta, CuentaDto model) {
        return Movimiento.builder()
                .fecha(LocalDate.now())
                .tipo(model.getTipo())
                .valor(model.getSaldoInicial())
                .saldo(model.getSaldoInicial())
                .observacion(MensajesGlobales.MSG_INFO_APERTURA)
                .cuenta(cuentaBuilder.builder(cuenta))
                .build();
    }
}
