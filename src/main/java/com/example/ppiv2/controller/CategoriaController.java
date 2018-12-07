
package com.example.ppiv2.controller;

import com.example.ppiv2.model.Categoria;
import com.example.ppiv2.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("/categorias");
        mv.addObject("categorias", service.findAll());

        return mv;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(Categoria categoria) {

        ModelAndView mv = new ModelAndView("/categoria");
        mv.addObject("categoria", categoria);

        return mv;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Long id) {

        return add(service.findOne(id));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") Long id) {

        service.delete(id);
        return findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid Categoria categoria, BindingResult result) {

        if (result.hasErrors()) {
            return add(categoria);
        }
        service.save(categoria);
        return findAll();
    }
}
