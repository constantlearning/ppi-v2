
package com.example.ppiv2.controller;

import com.example.ppiv2.model.Avaria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/avarias")
public class AvariaController {

    @GetMapping
    public ModelAndView findAll() {
        return new ModelAndView("/avarias");
    }

    @GetMapping("/add")
    public ModelAndView add(Avaria avaria) {
        return new ModelAndView("/avaria");
    }
}
