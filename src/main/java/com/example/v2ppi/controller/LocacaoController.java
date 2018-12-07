
package com.example.v2ppi.controller;

import com.example.v2ppi.model.Locacao;
import com.example.v2ppi.service.LocacaoService;
import com.example.v2ppi.service.PessoaService;
import com.example.v2ppi.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/locacoes")
public class LocacaoController {


    private final LocacaoService locacaoService;

    private final VeiculoService veiculoService;

    private final PessoaService pessoaService;


    @Autowired
    public LocacaoController(LocacaoService locacaoService, VeiculoService veiculoService, PessoaService pessoaService) {
        this.locacaoService = locacaoService;
        this.veiculoService = veiculoService;
        this.pessoaService = pessoaService;
    }


    @GetMapping
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("/locacoes");
        mv.addObject("locacoes", locacaoService.findAll());
        return mv;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(Locacao locacao) {

        ModelAndView mv = new ModelAndView("/locacao");
        mv.addObject("locacao", locacao);
        mv.addObject("veiculos", veiculoService.findAll());
        mv.addObject("pessoas", pessoaService.findAll());
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {

        return add(locacaoService.findOne(id));
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        locacaoService.delete(id);
        return findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid Locacao locacao, BindingResult result) {

        if (result.hasErrors()) {
            return add(locacao);
        }


        if(locacao.getPessoa() != null){
            locacao.setPessoa(pessoaService.findOne(locacao.getPessoa().getId()));
        }

        if(locacao.getVeiculo() != null){
            locacao.setVeiculo(veiculoService.findOne(locacao.getVeiculo().getId()));
        }

        locacaoService.save(locacao);
        return findAll();
    }
}
