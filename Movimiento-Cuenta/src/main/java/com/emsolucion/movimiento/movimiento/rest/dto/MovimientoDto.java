package com.emsolucion.movimiento.movimiento.rest.dto;

import com.emsolucion.movimiento.movimiento.rest.enums.TypeTipoEnum;
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

    private LocalDate fecha;

    private TypeTipoEnum tipo;

    private BigDecimal valor;

    private BigDecimal saldo;
}
