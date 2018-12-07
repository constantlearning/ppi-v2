
package com.example.ppiv2.service;

import com.example.ppiv2.model.Pessoa;
import com.example.ppiv2.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PessoaService {

    private final PessoaRepository repository;

    @Autowired
    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    public Pessoa findOne(Long id) {
        return (Pessoa) repository.getOne(id);
    }

    public Pessoa save(Pessoa post) {
        return (Pessoa) repository.saveAndFlush(post);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
