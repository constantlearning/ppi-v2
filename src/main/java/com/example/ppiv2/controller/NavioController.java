
package com.example.ppiv2.controller;

import com.example.ppiv2.model.Navio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/navios")
public class NavioController {

    @GetMapping
    public ModelAndView findAll() {
        return new ModelAndView("/navios");
    }

    @GetMapping("/add")
    public ModelAndView add(Navio navio) {
        return new ModelAndView("/navio");
    }
}
