package com.emsolucion.persona.personal.database.repository;

import com.emsolucion.persona.personal.database.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {
}
