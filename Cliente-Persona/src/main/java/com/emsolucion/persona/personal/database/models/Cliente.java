package com.emsolucion.persona.personal.database.models;

import com.emsolucion.persona.personal.rest.enums.StatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrePersist;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Persona implements Serializable {

    private Long clienteId;

    @Column(nullable = false)
    private String contrasenia;

    @Enumerated(EnumType.STRING)
    private StatusEnum estado;

    @PrePersist
    public void prePersist() {
        if (Objects.isNull(estado)) estado = StatusEnum.TRUE;
    }
}
