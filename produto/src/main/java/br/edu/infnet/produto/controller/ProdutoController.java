package br.edu.infnet.produto.controller;

import br.edu.infnet.produto.model.Produto;
import br.edu.infnet.produto.service.ProdutoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@RestController
@RequestMapping("/")
@AllArgsConstructor
@Slf4j
public class ProdutoController {
    private final ProdutoService produtoService;
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.findById(id);
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
