
package com.example.v2ppi.service;

import com.example.v2ppi.model.Navio;
import com.example.v2ppi.repository.NavioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NavioService {

    private final NavioRepository repository;

    @Autowired
    public NavioService(NavioRepository repository) {
        this.repository = repository;
    }

    public List<Navio> findAll() {
        return repository.findAll();
    }

    public Navio findOne(Long id) {
        return repository.getOne(id);
    }

    public Navio save(Navio navio) {
        return repository.saveAndFlush(navio);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
