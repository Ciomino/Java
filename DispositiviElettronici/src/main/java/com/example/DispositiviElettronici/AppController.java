package com.example.DispositiviElettronici;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Controller che gestisce le richieste HTTP per avviare applicazioni su diversi dispositivi.
@RestController
public class AppController {

    // Iniezione di dipendenze per Smartphone e Tablet.
    @Autowired
    private Smartphone smartphone;

    @Autowired
    private Tablet tablet;

    // Endpoint per avviare un'applicazione su uno smartphone o un tablet.
    @GetMapping("/avviaApp")
    public String avviaApp(@RequestParam String dispositivo, @RequestParam String nomeApp) {
        if ("smartphone".equalsIgnoreCase(dispositivo)) {
            return smartphone.avviaApplicazione(nomeApp);
        } else if ("tablet".equalsIgnoreCase(dispositivo)) {
            return tablet.avviaApplicazione(nomeApp);
        } else {
            return "Dispositivo non supportato.";
        }
    }
}
