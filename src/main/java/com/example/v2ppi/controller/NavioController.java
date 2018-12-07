
package com.example.v2ppi.controller;

import com.example.v2ppi.model.Navio;
import com.example.v2ppi.service.NavioService;
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
@RequestMapping(value = "/navios")
public class NavioController {

    private final NavioService service;

    @Autowired
    public NavioController(NavioService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("/navios");
        mv.addObject("navios", service.findAll());

        return mv;
    }

    @GetMapping("/add")
    public ModelAndView add(Navio navio) {

        return new ModelAndView("/navio")
                .addObject("navio", navio);
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
    public ModelAndView save(@Valid Navio navio, BindingResult result) {

        if (result.hasErrors()) {
            return add(navio);
        }
        service.save(navio);
        return findAll();
    }
}
