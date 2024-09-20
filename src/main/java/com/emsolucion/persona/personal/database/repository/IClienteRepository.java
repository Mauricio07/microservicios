package com.emsolucion.persona.personal.database.repository;

import com.emsolucion.persona.personal.database.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByClienteId(Long id);
}
