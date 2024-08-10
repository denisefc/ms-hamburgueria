package br.edu.infnet.pedido.service;

import br.edu.infnet.pedido.model.ItemPedido;
import br.edu.infnet.pedido.model.Pedido;
import br.edu.infnet.pedido.model.Produto;
import br.edu.infnet.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ProdutoService produtoService;

    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public BigDecimal calcularValorTotal(Pedido pedido) {
        return pedido.getItens().stream().map(this::calcularValorDeItem)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calcularValorDeItem(ItemPedido itemPedido) {
        Produto produto = produtoService.getById(itemPedido.getProdutoId());
        return produto.getPreco().multiply(new BigDecimal(itemPedido.getQuantidade()));
    }
}

