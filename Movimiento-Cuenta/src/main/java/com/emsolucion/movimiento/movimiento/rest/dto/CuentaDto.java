package com.emsolucion.movimiento.movimiento.rest.dto;

import com.emsolucion.movimiento.movimiento.rest.enums.StatusEnum;
import com.emsolucion.movimiento.movimiento.rest.enums.TypeTipoEnum;
import com.emsolucion.movimiento.movimiento.services.messages.MensajesGlobales;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDto implements Serializable {

    private Long id;

    @NotNull(message = MensajesGlobales.MSG_ERROR_CUENTA_REQUERIDA)
    private String numero;

    @NotNull(message = MensajesGlobales.MSG_ERROR_TIPO_REQUERIDO)
    private TypeTipoEnum tipo;

    @NotNull(message = MensajesGlobales.MSG_ERROR_SALDO_REQUERIDO)
    private BigDecimal saldoInicial;
    private StatusEnum estado;

    @NotNull(message = MensajesGlobales.MSG_ERROR_CLIENTE_IDENTIFICADOR_REQUERIDO)
    private Long clienteId;

    private ClienteDto cliente;
}
