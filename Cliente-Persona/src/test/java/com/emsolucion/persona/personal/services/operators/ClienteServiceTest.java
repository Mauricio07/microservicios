package com.emsolucion.persona.personal.services.operators;

import com.emsolucion.persona.personal.rest.dto.ClienteDto;
import com.emsolucion.persona.personal.rest.enums.TypeGeneroEnum;
import com.emsolucion.persona.personal.services.exception.ApplicacionException;
import com.emsolucion.persona.personal.services.messages.MensajesGlobales;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
class ClienteServiceTest {

    private final ClienteService clienteService;

    @Autowired
    public ClienteServiceTest(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Test
    @Order(1)
    void save() {
        ClienteDto clienteDto = clienteService.save(ClienteDto.builder()
                .nombre("Jose")
                .identificacion("1718938870")
                .direccion("Mena 2")
                .telefono("0992696254")
                .genero(TypeGeneroEnum.HOMBRE)
                .clienteId(10L)
                .edad(23)
                .contrasenia("test")
                .build());
        assertThat(clienteDto.getIdentificacion()).isEqualTo("1718938870");
        assertThat(clienteDto.getNombre()).isEqualTo("Jose");
    }

    @Test
    @Order(2)
    void getFindById() {
        ClienteDto clienteDto = clienteService.getFindById(10L);
        assertThat(clienteDto.getIdentificacion()).isEqualTo("1718938870");
    }

    @Test
    @Order(3)
    void update() {
        ClienteDto clienteDto = clienteService.getFindById(10L);
        clienteDto.setNombre("Jose Perales");
        ClienteDto clienteUpdate = clienteService.update(10L, clienteDto);
        assertThat(clienteUpdate.getIdentificacion()).isEqualTo("1718938870");
        assertThat(clienteUpdate.getNombre()).isEqualTo("Jose Perales");
    }

    @Test
    @Order(4)
    void delete() {
        assertThatExceptionOfType(ApplicacionException.class)
                .isThrownBy(() -> clienteService.delete(1L))
                .withMessage(MensajesGlobales.MSG_ERROR_ID_INVALIDO);
    }
}
