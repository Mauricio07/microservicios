package com.emsolucion.persona.personal.database.models;

import com.emsolucion.persona.personal.rest.enums.TypeGeneroEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false, unique = true, length = 13)
    private String identificacion;
    @Column(nullable = false)
    private String direccion;
    @Column(length = 10)
    private String telefono;

    @Enumerated(EnumType.STRING)
    private TypeGeneroEnum genero;
    @Column(nullable = false)
    private Integer edad;
}
