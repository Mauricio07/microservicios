package com.emsolucion.movimiento.movimiento.rest.dto;

import com.emsolucion.movimiento.movimiento.rest.enums.StatusEnum;
import com.emsolucion.movimiento.movimiento.rest.enums.TypeTipoEnum;
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

    private String numero;
    private TypeTipoEnum tipo;
    private BigDecimal saldoInicial;
    private StatusEnum estado;
}
