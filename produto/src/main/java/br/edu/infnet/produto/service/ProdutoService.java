package br.edu.infnet.produto.service;

import br.edu.infnet.produto.model.Produto;
import br.edu.infnet.produto.repository.ProdutoRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    public Optional<Produto> findById(Long id){
        return produtoRepository.findById(id);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }
}
