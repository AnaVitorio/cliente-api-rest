package br.com.lets.code.aula1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping({"/"})
    public String Home(){
        return "Homepage...";
    }
}
