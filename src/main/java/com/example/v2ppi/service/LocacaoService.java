package com.example.v2ppi.service;

import com.example.v2ppi.model.Locacao;
import com.example.v2ppi.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocacaoService {

    private final LocacaoRepository repository;

    @Autowired
    public LocacaoService(LocacaoRepository repository) {
        this.repository = repository;
    }

    public List<Locacao> findAll() {
        return repository.findAll();
    }

    public Locacao findOne(Long id) {
        return repository.getOne(id);
    }

    public Locacao save(Locacao locacao) {
        return repository.saveAndFlush(locacao);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
