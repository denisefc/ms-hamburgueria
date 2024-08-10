package br.edu.infnet.promocao.controller;

import br.edu.infnet.promocao.service.PromocaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class PromocaoController {
    private final PromocaoService promocaoService;
    @GetMapping
    public ResponseEntity<?> getPromocoes() {
        return ResponseEntity.ok(promocaoService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getPromocaoById(@PathVariable Long id) {
        return ResponseEntity.ok(promocaoService.getById(id));
    }
}
