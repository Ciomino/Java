package com.example.DispositiviElettronici;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

// Classe che rappresenta un tablet, estende DispositivoElettronico.
@Component
public class Tablet extends DispositivoElettronico {
    
    // Contatore statico per generare ID univoci per ogni utente.
    private static final AtomicInteger counter = new AtomicInteger(1);

    // Override del metodo avviaApplicazione per il comportamento specifico del tablet.
    @Override
    public String avviaApplicazione(String nomeApp) {
        StringBuilder sb = new StringBuilder();
        sb.append("Avviando ").append(nomeApp).append(" su Tablet...\n");
        sb.append(creaUtente());
        return sb.toString();
    }

    // Metodo che crea un utente con nome, password, punti e ID.
    private String creaUtente() {
        String nome = "user" + counter.get();
        String password = "password" + counter.get();
        float punti = new Random().nextFloat() * 100;
        int id = counter.getAndIncrement();

        ResocontoDigitale resoconto = new ResocontoDigitale(nome, password, punti, id);
        return resoconto.stampaResoconto();
    }
}
