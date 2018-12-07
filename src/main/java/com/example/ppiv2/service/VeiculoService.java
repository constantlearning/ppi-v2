
package com.example.ppiv2.service;

import com.example.ppiv2.model.Veiculo;
import com.example.ppiv2.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    @Autowired
    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public List<Veiculo> findAll() {
        return repository.findAll();
    }

    public Veiculo findOne(Long id) {
        return repository.getOne(id);
    }

    public Veiculo save(Veiculo vei) {
        return repository.saveAndFlush(vei);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
