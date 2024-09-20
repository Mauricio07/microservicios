package com.emsolucion.movimiento.movimiento.controller;

import com.emsolucion.movimiento.movimiento.rest.dto.CuentaDto;
import com.emsolucion.movimiento.movimiento.rest.dto.ModelResponse;
import com.emsolucion.movimiento.movimiento.services.operators.CuentaService;
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
@RequestMapping("${server.context-path}/cuentas")
@AllArgsConstructor
public class CuentaController {

    private final CuentaService cuentaService;

    @PostMapping("save")
    public ModelResponse saveData(@Valid @RequestBody CuentaDto model) {
        return ModelResponse.builder()
                .statusCode(HttpStatus.OK)
                .body(cuentaService.save(model))
                .build();
    }


    @PutMapping("update")
    public ModelResponse updateData(@RequestParam Long id, @Valid @RequestBody CuentaDto model) {
        return ModelResponse.builder()
                .statusCode(HttpStatus.OK)
                .body(cuentaService.update(id, model))
                .build();
    }

    @GetMapping("findByToken")
    public ModelResponse getData(@RequestParam Long id) {
        return ModelResponse.builder()
                .statusCode(HttpStatus.OK)
                .body(cuentaService.getFindById(id))
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
                .body(cuentaService.getAll(PageRequest
                        .of(page, size, orderBy == 1 ? Sort.Direction.ASC : Sort.Direction.DESC, field)))
                .build();

    }

    @DeleteMapping("delete")
    public ModelResponse deleteData(@RequestParam Long id) {
        cuentaService.delete(id);
        return ModelResponse.builder()
                .statusCode(HttpStatus.OK)
                .build();
    }

}
