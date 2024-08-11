package br.edu.infnet.pedido.service.clients;

import br.edu.infnet.pedido.model.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("PRODUTO-SERVICE")
public interface ProdutoClient {
    @GetMapping("/{id}")
    Produto getById(@PathVariable("id") Long id);
}
