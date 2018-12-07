package com.example.v2ppi.controller;

import com.example.v2ppi.model.Avaria;
import com.example.v2ppi.model.Locacao;
import com.example.v2ppi.model.Navio;
import com.example.v2ppi.repository.AvariaRepository;
import com.example.v2ppi.repository.LocacaoRepository;
import com.example.v2ppi.repository.NavioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private final NavioRepository navioRepository;
    private final AvariaRepository avariaRepository;
    private final LocacaoRepository locacaoRepository;

    @Autowired
    public ApiController(NavioRepository navioRepository, AvariaRepository avariaRepository, LocacaoRepository locacaoRepository) {
        this.navioRepository = navioRepository;
        this.avariaRepository = avariaRepository;
        this.locacaoRepository = locacaoRepository;
    }

    @GetMapping("/getnavios")
    public List<Navio> navios() {
        return navioRepository.findAll();
    }

    @GetMapping("/getavarias")
    public List<Avaria> avarias() {
        return avariaRepository.findAll();
    }

    @GetMapping("/getlocacoes")
    public List<Locacao> locacoes() {
        return locacaoRepository.findAll();
    }
}
