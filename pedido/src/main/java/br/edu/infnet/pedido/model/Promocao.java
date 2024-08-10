package br.edu.infnet.pedido.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Promocao {
    private Long id;
    private String nome;
    private Codigo codigo;
}
