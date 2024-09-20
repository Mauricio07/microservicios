package com.emsolucion.movimiento.movimiento.database.repository;

import com.emsolucion.movimiento.movimiento.database.models.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICuentaRepository extends JpaRepository<Cuenta, Long> {
}
