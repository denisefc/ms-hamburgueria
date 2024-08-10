package br.edu.infnet.promocao.service;

import br.edu.infnet.promocao.model.Promocao;
import br.edu.infnet.promocao.repository.PromocaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PromocaoService {
    private final PromocaoRepository promocaoRepository;
    public List<Promocao> getAll(){
        return promocaoRepository.findAll();
    }
    public Promocao getById(long id){
        return promocaoRepository.findById(id).get();
    }
}
