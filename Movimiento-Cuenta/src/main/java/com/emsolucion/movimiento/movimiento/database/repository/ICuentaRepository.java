package com.emsolucion.movimiento.movimiento.database.repository;

import com.emsolucion.movimiento.movimiento.database.models.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICuentaRepository extends JpaRepository<Cuenta, Long> {

    Optional<Cuenta> findByNumero(String numero);

}
