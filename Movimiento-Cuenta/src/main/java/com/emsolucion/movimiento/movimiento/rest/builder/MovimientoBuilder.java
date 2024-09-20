package com.emsolucion.movimiento.movimiento.rest.builder;

import com.emsolucion.movimiento.movimiento.database.models.Movimiento;
import com.emsolucion.movimiento.movimiento.rest.dto.MovimientoDto;
import org.springframework.stereotype.Component;

@Component
public class MovimientoBuilder {

    public MovimientoDto builder(Movimiento model) {
        return MovimientoDto.builder()
                .id(model.getId())
                .fecha(model.getFecha())
                .tipo(model.getTipo())
                .valor(model.getValor())
                .saldo(model.getSaldo())
                .build();
    }

    public Movimiento builder(MovimientoDto model) {
        return Movimiento.builder()
                .id(model.getId())
                .fecha(model.getFecha())
                .tipo(model.getTipo())
                .valor(model.getValor())
                .saldo(model.getSaldo())
                .build();
    }

    public Movimiento builderUpdate(Movimiento movimiento, MovimientoDto model) {
        return Movimiento.builder()
                .id(movimiento.getId())
                .fecha(model.getFecha())
                .tipo(model.getTipo())
                .valor(model.getValor())
                .saldo(model.getSaldo())
                .build();
    }
}
