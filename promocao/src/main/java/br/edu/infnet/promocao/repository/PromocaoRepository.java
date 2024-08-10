package br.edu.infnet.promocao.repository;

import br.edu.infnet.promocao.model.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromocaoRepository extends JpaRepository<Promocao, Long> {
}
