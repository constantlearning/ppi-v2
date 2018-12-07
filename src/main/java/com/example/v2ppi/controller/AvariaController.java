
package com.example.v2ppi.controller;

import com.example.v2ppi.model.Avaria;
import com.example.v2ppi.service.AvariaService;
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
@RequestMapping(value = "/avarias")
public class AvariaController {

    private final AvariaService service;

    @Autowired
    public AvariaController(AvariaService service) {
        this.service = service;
    }


    @GetMapping
    public ModelAndView findAll() {

        return new ModelAndView("/avarias")
                .addObject("avarias", service.findAll());
    }

    @GetMapping("/add")
    public ModelAndView add(Avaria avaria) {

        return new ModelAndView("/avaria")
                .addObject("avaria", avaria);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {

        return add(service.findOne(id));
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {

        service.delete(id);
        return findAll();
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid Avaria avaria, BindingResult result) {

        if (result.hasErrors()) {
            return add(avaria);
        }
        service.save(avaria);
        return findAll();
    }
}
