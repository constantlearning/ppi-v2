
package com.example.ppiv2.service;


import com.example.ppiv2.model.Categoria;
import com.example.ppiv2.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    @Autowired
    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria findOne(Long id) {
        return repository.getOne(id);
    }

    public Categoria save(Categoria cat) {
        return repository.saveAndFlush(cat);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
