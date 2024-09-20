package com.emsolucion.movimiento.movimiento.database.models;

import com.emsolucion.movimiento.movimiento.rest.enums.StatusEnum;
import com.emsolucion.movimiento.movimiento.rest.enums.TypeTipoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String numero;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeTipoEnum tipo;

    @Column(nullable = false)
    private BigDecimal saldoInicial;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum estado;

    @Column(nullable = false)
    private Long clienteId;

    @PrePersist
    public void prePersist() {
        if (Objects.isNull(estado)) estado = StatusEnum.TRUE;
    }

}
