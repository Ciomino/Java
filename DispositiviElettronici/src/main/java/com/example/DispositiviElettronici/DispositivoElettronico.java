package com.example.DispositiviElettronici;

// Classe astratta che rappresenta un dispositivo elettronico generico.
public abstract class DispositivoElettronico {
    
    // Metodo astratto che deve essere implementato dalle classi derivate.
    // Questo metodo avvia un'applicazione specificata dal nomeApp e restituisce un messaggio.
    public abstract String avviaApplicazione(String nomeApp);
}
