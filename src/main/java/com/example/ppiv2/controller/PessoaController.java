
package com.example.ppiv2.controller;

import com.example.ppiv2.model.Pessoa;
import com.example.ppiv2.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("/pessoas");
        mv.addObject("pessoas", service.findAll());

        return mv;
    }

    @GetMapping(value = "/add")
    public ModelAndView add(Pessoa pessoa) {

        ModelAndView mv = new ModelAndView("/pessoa");
        mv.addObject("pessoa", pessoa);

        return mv;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {

        return add(service.findOne(id));
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {

        service.delete(id);
        return findAll();
    }

    @PostMapping(value = "/save")
    public ModelAndView save(@Valid Pessoa pessoa, BindingResult result) {

        if (result.hasErrors()) {
            return add(pessoa);
        }
        service.save(pessoa);
        return findAll();
    }
}
