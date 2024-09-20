package com.emsolucion.movimiento.movimiento.controller;

import com.emsolucion.movimiento.movimiento.rest.dto.ModelResponse;
import com.emsolucion.movimiento.movimiento.rest.dto.MovimientoDto;
import com.emsolucion.movimiento.movimiento.services.operators.MovimientoService;
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

import java.time.LocalDate;

@RestController
@RequestMapping("/movimientos")
@AllArgsConstructor
public class MovimientoController {

    private final MovimientoService movimientoService;

    @PostMapping("save")
    public ModelResponse saveData(@Valid @RequestBody MovimientoDto model) {
        return ModelResponse.builder()
                .statusCode(HttpStatus.OK)
                .body(movimientoService.save(model))
                .build();
    }


    @PutMapping("update")
    public ModelResponse updateData(@RequestParam Long id, @Valid @RequestBody MovimientoDto model) {
        return ModelResponse.builder()
                .statusCode(HttpStatus.OK)
                .body(movimientoService.update(id, model))
                .build();
    }

    @GetMapping("findByToken")
    public ModelResponse getData(@RequestParam Long id) {
        return ModelResponse.builder()
                .statusCode(HttpStatus.OK)
                .body(movimientoService.getFindById(id))
                .build();
    }

    @GetMapping("getAllPageable")
    public ModelResponse getAllPageable(
            @RequestParam LocalDate fechaInicio,
            @RequestParam LocalDate fechaFinal,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String field,
            @RequestParam(defaultValue = "1") int orderBy
    ) {
        return ModelResponse.builder()
                .statusCode(HttpStatus.OK)
                .body(movimientoService.getAll(fechaInicio, fechaFinal, PageRequest
                        .of(page, size, orderBy == 1 ? Sort.Direction.ASC : Sort.Direction.DESC, field)))
                .build();

    }

    @DeleteMapping("delete")
    public ModelResponse deleteData(@RequestParam Long id) {
        movimientoService.delete(id);
        return ModelResponse.builder()
                .statusCode(HttpStatus.OK)
                .build();
    }

}
