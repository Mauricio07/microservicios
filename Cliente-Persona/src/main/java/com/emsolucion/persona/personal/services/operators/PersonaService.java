package com.emsolucion.persona.personal.services.operators;

import com.emsolucion.persona.personal.database.models.Persona;
import com.emsolucion.persona.personal.database.repository.IPersonaRepository;
import com.emsolucion.persona.personal.rest.builder.PersonaBuilder;
import com.emsolucion.persona.personal.rest.dto.PersonaDto;
import com.emsolucion.persona.personal.services.exception.ApplicacionException;
import com.emsolucion.persona.personal.services.messages.MensajesGlobales;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonaService {


    private final IPersonaRepository iPersonaRepository;
    private final PersonaBuilder personaBuilder;

    @Transactional
    public PersonaDto save(PersonaDto model) {
        return personaBuilder.builder(iPersonaRepository
                .save(personaBuilder.builder(model)));
    }

    @Transactional
    public PersonaDto update(Long id, PersonaDto model) {
        return personaBuilder.builder(iPersonaRepository
                .save(personaBuilder.builderUpdate(get(id), model)));
    }

    private Persona get(Long id) {
        return iPersonaRepository.findById(id)
                .orElseThrow(() -> new ApplicacionException(MensajesGlobales.MSG_ERROR_ID_INVALIDO));
    }

    public PersonaDto getFindById(Long id) {
        return personaBuilder.builder(get(id));
    }

    public Page<PersonaDto> getAll(PageRequest pageRequest) {
        return iPersonaRepository
                .findAll(pageRequest)
                .map(personaBuilder::builder);
    }

    @Transactional
    public void delete(Long id) {
        iPersonaRepository.delete(get(id));
    }

}
