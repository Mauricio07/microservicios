package com.emsolucion.movimiento.movimiento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovimientoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovimientoApplication.class, args);
	}

}
