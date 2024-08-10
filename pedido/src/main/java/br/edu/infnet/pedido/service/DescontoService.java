package br.edu.infnet.pedido.service;

import br.edu.infnet.pedido.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class DescontoService {
    private final ProdutoService produtoService;
    private final PromocaoService promocaoService;

    public BigDecimal getTotalDesconto(Pedido pedido) {
        return  pedido.getItens()
                .stream().map(this::calcularDesconto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calcularDesconto(ItemPedido itemPedido) {
        Produto produto = produtoService.getById(itemPedido.getProdutoId());
        Promocao promocao = promocaoService.getById(produto.getPromocaoId());
        BigDecimal descontos = getDescontos(promocao.getCodigo());
        return produto.getPreco().multiply(descontos).multiply(new BigDecimal(itemPedido.getQuantidade()));
    }

    private BigDecimal getDescontos(Codigo codigo){
        return switch (codigo){
            case PROMOSEMANAL -> new BigDecimal("0.10");
            case PROMOESPECIAL ->  new BigDecimal("0.15");
            case SEMPROMO -> new BigDecimal("0");
        };
    }
}
