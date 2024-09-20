package com.emsolucion.movimiento.movimiento.services.operators;

import com.emsolucion.movimiento.movimiento.database.models.Movimiento;
import com.emsolucion.movimiento.movimiento.database.repository.IMovimientoRepository;
import com.emsolucion.movimiento.movimiento.rest.builder.MovimientoBuilder;
import com.emsolucion.movimiento.movimiento.rest.dto.MovimientoDto;
import com.emsolucion.movimiento.movimiento.services.exceptions.MovimientoException;
import com.emsolucion.movimiento.movimiento.services.messages.MensajesGlobales;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class MovimientoService {


    private final IMovimientoRepository iMovimientoRepository;
    private final MovimientoBuilder movimientoBuilder;

    @Transactional
    public MovimientoDto save(MovimientoDto model) {
        validarSaldo(model.getNumeroCuenta());
        return movimientoBuilder.builder(iMovimientoRepository
                .save(movimientoBuilder.builder(model)));
    }

    @Transactional
    public MovimientoDto update(Long id, MovimientoDto model) {
        validarSaldo(model.getNumeroCuenta());
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

    public Page<MovimientoDto> getAll(PageRequest pageRequest) {
        return iMovimientoRepository
                .findAll(pageRequest)
                .map(movimientoBuilder::builder);
    }

    private void validarSaldo(String numeroCuenta) {
        Movimiento movimiento = iMovimientoRepository.findFirstByCuentaNumeroOrderByIdDesc(numeroCuenta);
        if (movimiento.getSaldo().compareTo(BigDecimal.ZERO) <= 0) {
            throw new MovimientoException(MensajesGlobales.MSG_ERROR_SALDO_INVALIDO);
        }
    }

    @Transactional
    public void delete(Long id) {
        iMovimientoRepository.delete(get(id));
    }

}
