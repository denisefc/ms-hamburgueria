package br.edu.infnet.pedido.controller;

import br.edu.infnet.pedido.model.Pedido;
import br.edu.infnet.pedido.service.DescontoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/desconto")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Descontos")
public class DescontoController {
    private final DescontoService descontoService;
    @Operation(summary = "Adiciona um desconto", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Adicionado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos")
    })
    @PostMapping
    public ResponseEntity<?> calcularDesconto(@RequestBody Pedido pedido){
        log.info("Calculando desconto: {}", pedido);
        BigDecimal totalDesconto = descontoService.getTotalDesconto(pedido);
        return ResponseEntity.ok(Map.of("totalDesconto", totalDesconto));
    }
}
