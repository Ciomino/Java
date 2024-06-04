package com.example.DispositiviElettronici;

import org.springframework.stereotype.Component;

// Classe che rappresenta uno smartphone, estende DispositivoElettronico.
@Component
public class Smartphone extends DispositivoElettronico {
    
    // Override del metodo avviaApplicazione per il comportamento specifico dello smartphone.
    @Override
    public String avviaApplicazione(String nomeApp) {
        StringBuilder sb = new StringBuilder();
        sb.append("Avviando ").append(nomeApp).append(" su Smartphone...\n");
        sb.append(logging("user123", "password123"));
        return sb.toString();
    }

    // Metodo logging per simulare l'accesso con nome utente e password.
    private String logging(String nome, String password) {
        return "Logging in con nome: " + nome + " e password: " + password + "\n";
    }
}
