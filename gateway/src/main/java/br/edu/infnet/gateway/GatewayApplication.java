package br.edu.infnet.gateway;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API Gateway", version = "1.0", description = "Documentation API Gateway v1.0"))
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route(r -> r.path("/produto/v3/api-docs").and().method(HttpMethod.GET).uri("lb://PRODUTO-SERVICE"))
				.route(r -> r.path("/promocao/v3/api-docs").and().method(HttpMethod.GET).uri("lb://PROMOCAO-SERVICE"))
				.route(r -> r.path("/pedido/v3/api-docs").and().method(HttpMethod.GET).uri("lb://PEDIDO-SERVICE"))
				.build();
	}

}
