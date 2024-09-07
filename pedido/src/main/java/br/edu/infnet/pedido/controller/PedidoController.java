package br.edu.infnet.pedido.controller;

import br.edu.infnet.pedido.model.Pedido;
import br.edu.infnet.pedido.service.DescontoService;
import br.edu.infnet.pedido.service.PedidoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Pedidos")
public class PedidoController {
    private final PedidoService pedidoService;
    private final DescontoService descontoService;

    @Operation(summary = "Adiciona um pedido", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Adicionado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos")
    })
    @PostMapping
    public ResponseEntity<Pedido> create(@RequestBody Pedido pedido){
        log.info("Criando Pedido:" + pedido.toString());
        BigDecimal totalDesconto = descontoService.getTotalDesconto(pedido);
        pedidoService.salvar(pedido);
        BigDecimal valorSemDesconto = pedidoService.calcularValorTotal(pedido);
        pedido.setTotalSemDesconto(valorSemDesconto);
        pedido.setDesconto(totalDesconto);
        pedido.setValorTotal(valorSemDesconto.subtract(totalDesconto));
        pedidoService.salvar(pedido);
        return ResponseEntity.ok(pedido);
    }
}
