package br.edu.infnet.promocao.controller;

import br.edu.infnet.promocao.service.PromocaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
@Tag(name = "Promoções")
public class PromocaoController {
    private final PromocaoService promocaoService;
    @Operation(summary = "Busca todos as promoções", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
    })
    @GetMapping
    public ResponseEntity<?> getPromocoes() {
        return ResponseEntity.ok(promocaoService.getAll());
    }

    @Operation(summary = "Busca promoção de determinado id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getPromocaoById(@PathVariable Long id) {
        return ResponseEntity.ok(promocaoService.getById(id));
    }
}
