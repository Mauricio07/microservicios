package com.emsolucion.movimiento.movimiento.services.operators;

import com.emsolucion.movimiento.movimiento.database.models.Movimiento;
import com.emsolucion.movimiento.movimiento.database.repository.IMovimientoRepository;
import com.emsolucion.movimiento.movimiento.rest.builder.CuentaBuilder;
import com.emsolucion.movimiento.movimiento.rest.builder.MovimientoBuilder;
import com.emsolucion.movimiento.movimiento.rest.dto.CuentaDto;
import com.emsolucion.movimiento.movimiento.rest.dto.MovimientoDto;
import com.emsolucion.movimiento.movimiento.services.exceptions.MovimientoException;
import com.emsolucion.movimiento.movimiento.services.messages.MensajesGlobales;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@AllArgsConstructor
public class MovimientoService {


    private final IMovimientoRepository iMovimientoRepository;
    private final MovimientoBuilder movimientoBuilder;
    private final CuentaBuilder cuentaBuilder;

    @Transactional
    public MovimientoDto save(MovimientoDto model) {
        validarSaldo(model.getNumeroCuenta());
        calcularSaldo(model);
        return movimientoBuilder.builder(iMovimientoRepository
                .save(movimientoBuilder.builder(model)));
    }

    @Transactional
    public MovimientoDto update(Long id, MovimientoDto model) {
        validarSaldo(model.getNumeroCuenta());
        calcularSaldo(model);
        return movimientoBuilder.builder(iMovimientoRepository
                .save(movimientoBuilder.builderUpdate(get(id), model)));
    }

    private Movimiento get(Long id) {
        return iMovimientoRepository.findById(id)
                .orElseThrow(() -> new MovimientoException(MensajesGlobales.MSG_ERROR_ID_INVALIDO));
    }

    public MovimientoDto getFindById(Long id) {
        return movimientoBuilder.builder(get(id));
    }

    public Page<MovimientoDto> getAll(LocalDate fechaInicio, LocalDate fechaFinal, PageRequest pageRequest) {
        if (fechaFinal.isBefore(fechaInicio)) {
            throw new MovimientoException(MensajesGlobales.MSG_ERROR_FECHA_INVALIDA);
        }
        return iMovimientoRepository
                .findAllByFechaBetweenOrderByFechaDesc(fechaInicio, fechaFinal, pageRequest)
                .map(movimientoBuilder::builder);
    }

    private void validarSaldo(String numeroCuenta) {
        Movimiento movimiento = iMovimientoRepository.findFirstByCuentaNumeroOrderByIdDesc(numeroCuenta);
        if (movimiento.getSaldo().compareTo(BigDecimal.ZERO) <= 0) {
            throw new MovimientoException(MensajesGlobales.MSG_ERROR_SALDO_INVALIDO);
        }
    }

    private void calcularSaldo(MovimientoDto model) {
        Movimiento movimiento = iMovimientoRepository.findFirstByCuentaNumeroOrderByIdDesc(model.getNumeroCuenta());
        model.setSaldo(movimiento.getSaldo().add(model.getValor()));
        model.setCuenta(cuentaBuilder.builder(movimiento.getCuenta()));
    }

    @Transactional
    public void delete(Long id) {
        iMovimientoRepository.delete(get(id));
    }

    @Transactional
    public CuentaDto saveCuenta(CuentaDto cuenta, CuentaDto model) {
        Movimiento movimiento = iMovimientoRepository.save(movimientoBuilder.builderCuenta(cuenta, model));
        return cuentaBuilder.builder(movimiento.getCuenta());
    }
}
