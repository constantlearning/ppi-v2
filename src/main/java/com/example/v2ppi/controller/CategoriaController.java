
package com.example.v2ppi.controller;

import com.example.v2ppi.model.Categoria;
import com.example.v2ppi.service.CategoriaService;
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
@RequestMapping(value = "/categorias")
public class CategoriaController {

    private final CategoriaService service;

    @Autowired
    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView findAll() {

        return new ModelAndView("/categorias")
                .addObject("categorias", service.findAll());
    }

    @GetMapping("/add")
    public ModelAndView add(Categoria categoria) {

        return new ModelAndView("/categoria")
                .addObject("categoria", categoria);
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
    public ModelAndView save(@Valid Categoria categoria, BindingResult result) {

        if (result.hasErrors()) {
            return add(categoria);
        }
        service.save(categoria);
        return findAll();
    }
}
