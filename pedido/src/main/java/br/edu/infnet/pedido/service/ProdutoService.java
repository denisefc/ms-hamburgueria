package br.edu.infnet.pedido.service;

import br.edu.infnet.pedido.model.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    public Produto getById(Long produtoId) {
        var serverUrl = String.format("http://localhost:8080/%d", produtoId);
        RestClient client = RestClient.create();
        return client.get()
                .uri(serverUrl).retrieve()
                .toEntity(Produto.class).getBody();
    }
}
