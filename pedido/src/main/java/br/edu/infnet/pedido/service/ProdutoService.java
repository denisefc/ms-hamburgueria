package br.edu.infnet.pedido.service;

import br.edu.infnet.pedido.model.Produto;
import br.edu.infnet.pedido.service.clients.ProdutoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoClient client;
    public Produto getById(Long produtoId) {
        return client.getById(produtoId);
        /*var serverUrl = String.format("http://localhost:8080/%d", produtoId);
        RestClient client = RestClient.create();
        return client.get().uri(serverUrl).retrieve()
                .toEntity(Produto.class).getBody();*/
    }
}
