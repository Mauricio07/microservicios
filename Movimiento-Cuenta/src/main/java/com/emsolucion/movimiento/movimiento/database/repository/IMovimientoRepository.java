package com.emsolucion.movimiento.movimiento.database.repository;

import com.emsolucion.movimiento.movimiento.database.models.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovimientoRepository extends JpaRepository<Movimiento, Long> {
}
