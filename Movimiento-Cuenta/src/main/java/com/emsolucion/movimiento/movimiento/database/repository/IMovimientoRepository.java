package com.emsolucion.movimiento.movimiento.database.repository;

import com.emsolucion.movimiento.movimiento.database.models.Movimiento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IMovimientoRepository extends JpaRepository<Movimiento, Long> {

    Movimiento findFirstByCuentaNumeroOrderByIdDesc(String cuenta);

    Page<Movimiento> findAllByFechaBetweenOrderByFechaAsc(LocalDate fechaInicio, LocalDate fechaFinal, PageRequest pageRequest);
}
