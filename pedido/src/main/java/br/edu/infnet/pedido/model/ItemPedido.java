package br.edu.infnet.pedido.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemPedido {
    @Schema(description = "Essa é a quantidade de itens do produto", example = "2")
    private Long quantidade;
    @Schema(description = "Esse é o id do produto", example = "1")
    private Long produtoId;
}
