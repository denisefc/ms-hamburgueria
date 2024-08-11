package br.edu.infnet.pedido.service.clients;

import br.edu.infnet.pedido.model.Promocao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("PROMOCAO-SERVICE")
public interface PromocaoClient {
    @GetMapping("/{id}")
    Promocao getById(@PathVariable("id") Long id);
}
