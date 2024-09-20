package com.emsolucion.persona.personal.controller;

import com.emsolucion.persona.personal.rest.dto.ClienteDto;
import com.emsolucion.persona.personal.rest.dto.ModelResponse;
import com.emsolucion.persona.personal.services.operators.ClienteService;
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
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {


    private final ClienteService clienteService;

    @PostMapping("save")
    public ModelResponse saveData(@Valid @RequestBody ClienteDto model) {
        return ModelResponse.builder()
                .statusCode(HttpStatus.OK)
                .body(clienteService.save(model))
                .build();
    }


    @PutMapping("update")
    public ModelResponse updateData(@RequestParam Long id, @Valid @RequestBody ClienteDto model) {
        return ModelResponse.builder()
                .statusCode(HttpStatus.OK)
                .body(clienteService.update(id, model))
                .build();
    }

    @GetMapping("findById")
    public ModelResponse getData(@RequestParam Long id) {
        return ModelResponse.builder()
                .statusCode(HttpStatus.OK)
                .body(clienteService.getFindById(id))
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
                .body(clienteService.getAll(PageRequest.of(page, size, orderBy == 1 ? Sort.Direction.ASC : Sort.Direction.DESC, field)))
                .build();

    }

    @DeleteMapping("delete")
    public ModelResponse deleteData(@RequestParam Long id) {
        clienteService.delete(id);
        return ModelResponse.builder()
                .statusCode(HttpStatus.OK)
                .build();
    }

}
