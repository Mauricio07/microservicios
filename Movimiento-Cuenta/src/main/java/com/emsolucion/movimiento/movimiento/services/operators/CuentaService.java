package com.emsolucion.movimiento.movimiento.services.operators;

import com.emsolucion.movimiento.movimiento.database.models.Cuenta;
import com.emsolucion.movimiento.movimiento.database.repository.ICuentaRepository;
import com.emsolucion.movimiento.movimiento.rest.builder.CuentaBuilder;
import com.emsolucion.movimiento.movimiento.rest.dto.CuentaDto;
import com.emsolucion.movimiento.movimiento.services.exceptions.MovimientoException;
import com.emsolucion.movimiento.movimiento.services.messages.MensajesGlobales;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CuentaService {


    private final ICuentaRepository iCuentaRepository;
    private final CuentaBuilder cuentaBuilder;
    private final MovimientoService movimientoService;

    @Transactional
    public CuentaDto save(CuentaDto model) {
        validarCuenta(model); // validación del número de cuenta
        CuentaDto cuenta = cuentaBuilder.builder(iCuentaRepository.save(cuentaBuilder.builder(model)));
        return movimientoService.saveCuenta(cuenta, model);
    }

    @Transactional
    public CuentaDto update(Long id, CuentaDto model) {
        validarCuenta(model); // validación del número de cuenta
        return cuentaBuilder.builder(iCuentaRepository
                .save(cuentaBuilder.builderUpdate(get(id), model)));
    }

    private Cuenta get(Long id) {
        return iCuentaRepository.findById(id)
                .orElseThrow(() -> new MovimientoException(MensajesGlobales.MSG_ERROR_ID_INVALIDO));
    }

    public CuentaDto getFindById(Long id) {
        return cuentaBuilder.builder(get(id));
    }

    public Page<CuentaDto> getAll(PageRequest pageRequest) {
        return iCuentaRepository
                .findAll(pageRequest)
                .map(cuentaBuilder::builder);
    }

    @Transactional
    public Boolean delete(Long id) {
        iCuentaRepository.delete(get(id));
        return true;
    }

    public void validarCuenta(CuentaDto cuentaDto) {
        Optional<Cuenta> cuentaOptional = iCuentaRepository.findByNumero(cuentaDto.getNumero());
        if (cuentaOptional.isPresent()) {
            if (Objects.isNull(cuentaDto.getId())) {
                throw new MovimientoException(MensajesGlobales.MSG_ERROR_CUENTA_INVALIDA);
            } else if (!cuentaDto.getId().equals(cuentaOptional.get().getId())) {
                throw new MovimientoException(MensajesGlobales.MSG_ERROR_CUENTA_INVALIDA);
            }
        }
    }

}
