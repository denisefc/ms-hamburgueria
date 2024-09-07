package br.edu.infnet.produto.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="produto")
public class Produto {
    @Schema(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(description = "Esse é o nome do produto", example = "Hambúrguer")
    private String nome;
    @Schema(description = "Esse é o preço do produto", example = "20.00")
    private BigDecimal preco;
    @Schema(description = "Esse é o nome da promoção do produto", example = "Promoção do dia")
    private String promocao;
    @Schema(description = "Esse é o id da promoção do produto", example = "1")
    @Column(name = "promocao_id")
    private long promocaoId;
}
