package br.edu.infnet.pedido.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document(collection = "pedidos")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pedido {
    @Schema(hidden = true)
    @Id
    private String id;
    private List<ItemPedido> itens;
    @Schema(hidden = true)
    private BigDecimal totalSemDesconto;
    @Schema(hidden = true)
    private BigDecimal desconto;
    @Schema(hidden = true)
    private BigDecimal valorTotal;
}
