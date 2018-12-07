
package com.example.v2ppi.service;

import com.example.v2ppi.model.Avaria;
import com.example.v2ppi.repository.AvariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AvariaService {

    private final AvariaRepository repository;

    @Autowired
    public AvariaService(AvariaRepository repository) {
        this.repository = repository;
    }

    public List<Avaria> findAll() {
        return repository.findAll();
    }

    public Avaria findOne(Long id) {
        return repository.getOne(id);
    }

    public Avaria save(Avaria pessoa) {
        return repository.saveAndFlush(pessoa);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
