package br.edu.infnet.produto.controller;

import br.edu.infnet.produto.model.Produto;
import br.edu.infnet.produto.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/")
@AllArgsConstructor
@Slf4j
@Tag(name = "Produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    @Operation(summary = "Adiciona um produto", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Adicionado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos")
    })
    @PostMapping("/save")
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.save(produto), HttpStatus.CREATED);
    }

    @Operation(summary = "Busca todos os produtos", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
    })
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @Operation(summary = "Busca produto de determinado id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        log.info("Encontrar produto por id: {}", id);
        Optional<Produto> produto = produtoService.findById(id);
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Edita um produto", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Edição realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos")
    })
    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> edit(@PathVariable Long id, @RequestBody Produto produto) {
        produtoService.edit(id, produto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Exclui um produto", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Deletado com sucesso")
    })
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
