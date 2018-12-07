
package com.example.v2ppi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView greeting(
            @RequestParam(name = "name",
                    required = false, defaultValue = "World") String name) {
        ModelAndView mv = new ModelAndView("/hello");
        mv.addObject("name", name);
        return mv;
    }
}
