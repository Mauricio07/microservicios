package com.emsolucion.persona.personal.controller;

import com.emsolucion.persona.personal.rest.dto.ModelResponse;
import com.emsolucion.persona.personal.rest.dto.PersonaDto;
import com.emsolucion.persona.personal.services.operators.PersonaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@AllArgsConstructor
public class PersonaController {


    private final PersonaService personaService;

    @PostMapping("save")
    public ModelResponse saveData(@Valid @RequestBody PersonaDto model) {
        return ModelResponse.builder()
                .statusCode(HttpStatus.OK)
                .body(personaService.save(model))
                .build();
    }


    @PutMapping("update")
    public ModelResponse updateData(@RequestParam Long id, @Valid @RequestBody PersonaDto model) {
        return ModelResponse.builder()
                .statusCode(HttpStatus.OK)
                .body(personaService.update(id, model))
                .build();
    }

    @GetMapping("findByToken")
    public ModelResponse getData(@RequestParam Long id) {
        return ModelResponse.builder()
                .statusCode(HttpStatus.OK)
                .body(personaService.getFindById(id))
                .build();
    }

    @GetMapping("getAllPageable")
    public ModelResponse getAllPageable(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String field,
            @RequestParam(defaultValue = "1") int orderBy
    ) {
        return ModelResponse.builder()
                .statusCode(HttpStatus.OK)
                .body(personaService.getAll(PageRequest
                        .of(page, size, orderBy == 1 ? Sort.Direction.ASC : Sort.Direction.DESC, field)))
                .build();

    }

    @DeleteMapping("delete")
    public ModelResponse deleteData(@RequestParam Long id) {
        personaService.delete(id);
        return ModelResponse.builder()
                .statusCode(HttpStatus.OK)
                .build();
    }

}
