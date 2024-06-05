package com.example.prova;

public class DatiUtente {
    private String nome;
    private String cognome;
    private String email;

    public DatiUtente(String nome, String cognome, String email){
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
    }
    

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DatiUtente{");
        sb.append("nome=").append(nome);
        sb.append(", cognome=").append(cognome);
        sb.append(", email=").append(email);
        sb.append('}');
        return sb.toString();
    }

    
}
