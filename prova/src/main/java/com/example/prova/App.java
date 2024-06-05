package com.example.prova;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/Figlio")
public class App {
    final Figlio son;

    public App(Figlio son){
        this.son= son;
    } 

    @GetMapping("/ProvaApplication")
    @ResponseBody  // Aggiunge la risposta come testo
    public String ProvaApplication() {
        return son.toString();
    }
}

