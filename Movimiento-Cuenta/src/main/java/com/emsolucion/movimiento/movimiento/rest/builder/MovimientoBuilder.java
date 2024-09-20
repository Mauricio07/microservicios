package com.emsolucion.movimiento.movimiento.rest.builder;

import com.emsolucion.movimiento.movimiento.database.models.Movimiento;
import com.emsolucion.movimiento.movimiento.rest.dto.CuentaDto;
import com.emsolucion.movimiento.movimiento.rest.dto.MovimientoDto;
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
                .numeroCuenta(model.getCuenta().getNumero())
                .build();
    }

    public Movimiento builder(MovimientoDto model) {
        return Movimiento.builder()
                .id(model.getId())
                .fecha(model.getFecha())
                .tipo(model.getTipo())
                .valor(model.getValor())
                .saldo(model.getSaldo())
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
                .build();
    }

    public Movimiento builderCuenta(CuentaDto cuenta, CuentaDto model) {
        return Movimiento.builder()
                .fecha(LocalDate.now())
                .tipo(model.getTipo())
                .valor(model.getSaldoInicial())
                .saldo(model.getSaldoInicial())
                .cuenta(cuentaBuilder.builder(cuenta))
                .build();
    }
}
