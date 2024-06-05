package com.example.prova;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Figlio extends DatiUtente {

    public Figlio(@Value("${figlio.nome}") String nome, 
                  @Value("${figlio.cognome}") String cognome, 
                  @Value("${figlio.email}") String email) {
        super(nome, cognome, email);
    }
}
