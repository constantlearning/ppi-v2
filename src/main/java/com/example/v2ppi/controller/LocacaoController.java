
package com.example.v2ppi.controller;

import com.example.v2ppi.model.Locacao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/locacoes")
public class LocacaoController {

    @GetMapping
    public ModelAndView findAll() {
        return new ModelAndView("/locacoes");
    }

    @GetMapping("/add")
    public ModelAndView add(Locacao locacao) {
        return new ModelAndView("/locacao");
    }
}
