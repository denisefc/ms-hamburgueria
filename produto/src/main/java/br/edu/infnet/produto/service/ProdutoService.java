package br.edu.infnet.produto.service;

import br.edu.infnet.produto.model.Produto;
import br.edu.infnet.produto.repository.ProdutoRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Transactional
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Optional<Produto> findById(Long id){
        return produtoRepository.findById(id);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto edit(Long id, Produto atualizado) {
        atualizado.setId(id);
        return produtoRepository.save(atualizado);
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
