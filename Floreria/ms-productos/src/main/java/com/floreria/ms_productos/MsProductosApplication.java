package com.floreria.ms_productos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(servers = {
		@Server(url = "http://localhost:8081", description = "Ruta a través del Gateway")
})
public class MsProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProductosApplication.class, args);
	}

}
