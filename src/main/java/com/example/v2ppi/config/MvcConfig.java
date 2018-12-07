package com.example.v2ppi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/veiculos").setViewName("veiculos");
        registry.addViewController("/categorias").setViewName("categorias");
        registry.addViewController("/avarias").setViewName("avarias");
        registry.addViewController("/pessoas").setViewName("pessoas");
        registry.addViewController("/locacoes").setViewName("locacoes");
        registry.addViewController("/navios").setViewName("navios");

    }

}