package br.edu.infnet.pedido.service;

import br.edu.infnet.pedido.model.Promocao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class PromocaoService {
    public Promocao getById(long promocaoId) {
        RestClient client = RestClient.create();
        String serverUrl = String.format("http://localhost:8081/%d", promocaoId);
        return client.get().uri(serverUrl).retrieve()
                .toEntity(Promocao.class).getBody();
    }
}
