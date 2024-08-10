package br.edu.infnet.pedido.controller;

import br.edu.infnet.pedido.model.Pedido;
import br.edu.infnet.pedido.service.DescontoService;
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
public class DescontoController {
    private final DescontoService descontoService;
    @PostMapping
    public ResponseEntity<?> calcularDesconto(@RequestBody Pedido pedido){
        log.info("Calculando desconto: {}", pedido);
        BigDecimal totalDesconto = descontoService.getTotalDesconto(pedido);
        return ResponseEntity.ok(Map.of("totalDesconto", totalDesconto));
    }
}
