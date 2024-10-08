package com.emsolucion.movimiento.movimiento.rest.dto;

import com.emsolucion.movimiento.movimiento.rest.enums.TypeTipoEnum;
import com.emsolucion.movimiento.movimiento.services.messages.MensajesGlobales;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoDto implements Serializable {

    private Long id;

    @NotNull(message = MensajesGlobales.MSG_ERROR_FECHA_REQUERIDA)
    private LocalDate fecha;

    @NotNull(message = MensajesGlobales.MSG_ERROR_TIPO_REQUERIDO)
    private TypeTipoEnum tipo;

    @NotNull(message = MensajesGlobales.MSG_ERROR_VALOR_REQUERIDO)
    private BigDecimal valor;

    private BigDecimal saldo;

    @NotNull(message = MensajesGlobales.MSG_ERROR_CUENTA_REQUERIDA)
    private String numeroCuenta;

    private CuentaDto cuenta;

    private String observacion;
}
