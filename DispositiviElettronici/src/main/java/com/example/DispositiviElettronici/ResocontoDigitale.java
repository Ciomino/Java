package com.example.DispositiviElettronici;

// Classe che rappresenta il resoconto digitale di un utente.
public class ResocontoDigitale {
    private String nome;
    private String password;
    private float punti;
    private int id;


    // Costruttore per inizializzare il resoconto dell'utente.
    public ResocontoDigitale(String nome, String password, float punti, int id) {
        this.nome = nome;
        this.password = password;
        this.punti = punti;
        this.id = id;
    }

    // Metodo che restituisce una stringa con i dettagli del resoconto dell'utente.
    public String stampaResoconto() {
        return """
               Resoconto Utente:
               Nome: """ + nome + "\n" +
               "Password: " + password + "\n" +
               "Punti: " + punti + "\n" +
               "ID: " + id + "\n";
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getPunti() {
        return punti;
    }

    public void setPunti(float punti) {
        this.punti = punti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
