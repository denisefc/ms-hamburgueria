package br.edu.infnet.produto.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
//import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@OpenAPIDefinition(servers = {@Server(url = "/produto", description = "Produtos da Hamburgueria")})
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                //.servers(List.of(new Server().url(url)))
                .info(new Info()
                        .title("API de uma hamburgueria")
                        .description(
                                "Um projeto de uma hamburgueria, feito com Spring Boot e Java 17."));
    }
}
