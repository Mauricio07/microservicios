package com.emsolucion.persona.personal.services.operators;

import com.emsolucion.persona.personal.database.models.Cliente;
import com.emsolucion.persona.personal.database.repository.IClienteRepository;
import com.emsolucion.persona.personal.rest.builder.ClienteBuilder;
import com.emsolucion.persona.personal.rest.dto.ClienteDto;
import com.emsolucion.persona.personal.services.exception.ApplicacionException;
import com.emsolucion.persona.personal.services.messages.MensajesGlobales;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService {


    private final IClienteRepository iClienteRepository;
    private final ClienteBuilder clienteBuilder;

    @Transactional
    public ClienteDto save(ClienteDto model) {
        return clienteBuilder.builder(iClienteRepository
                .save(clienteBuilder.builder(model)));
    }

    @Transactional
    public ClienteDto update(Long id, ClienteDto model) {
        return clienteBuilder.builder(iClienteRepository
                .save(clienteBuilder.builderUpdate(get(id), model)));
    }

    private Cliente get(Long id) {
        return iClienteRepository.findByClienteId(id)
                .orElseThrow(() -> new ApplicacionException(MensajesGlobales.MSG_ERROR_ID_INVALIDO));
    }

    public ClienteDto getFindById(Long id) {
        return clienteBuilder.builder(get(id));
    }

    public Page<ClienteDto> getAll(PageRequest pageRequest) {
        return iClienteRepository.findAll(pageRequest)
                .map(clienteBuilder::builder);
    }

    @Transactional
    public void delete(Long id) {
        iClienteRepository.delete(get(id));
    }

}
