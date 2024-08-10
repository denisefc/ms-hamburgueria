package br.edu.infnet.pedido.repository;

import br.edu.infnet.pedido.model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<Pedido, String> {
}
