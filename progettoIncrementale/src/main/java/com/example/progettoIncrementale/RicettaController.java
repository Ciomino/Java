package com.example.progettoIncrementale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class RicettaController {
    
    @Autowired
    private RicettaService ricettaService;

    @GetMapping("/")
    public String mostraRicette(Model model) {
        List<Ricetta> ricette = ricettaService.findAll();
        model.addAttribute("ricetteList", ricette);
        return "home";
    }

    @GetMapping("/aggiungi")
    public String mostraFormAggiungi(Ricetta ricetta){
        return "aggiungi";
    }

    @PostMapping("/aggiungi")
    public String aggiungiRicetta(Ricetta ricetta){
        ricettaService.save(ricetta);
        return "redirect:/";
    }

    

    
}
