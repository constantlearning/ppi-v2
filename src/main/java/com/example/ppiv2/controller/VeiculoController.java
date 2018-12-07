
package com.example.ppiv2.controller;


import com.example.ppiv2.model.Veiculo;
import com.example.ppiv2.service.CategoriaService;
import com.example.ppiv2.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("/veiculos");
        mv.addObject("veiculos", service.findAll());

        return mv;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(Veiculo veiculo) {

        ModelAndView mv = new ModelAndView("/veiculo");
        mv.addObject("veiculo", veiculo);
        mv.addObject("categorias", categoriaService.findAll());

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
    public ModelAndView save(@Valid Veiculo veiculo, BindingResult result) {

        if (result.hasErrors()) {
            return add(veiculo);
        }

        if (veiculo.getCategoria() != null) {
            veiculo.setCategoria(
                    categoriaService.findOne(veiculo.getCategoria().getId())
            );
        }
        service.save(veiculo);

        return findAll();
    }
}
