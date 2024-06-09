package com.example.progettoIncrementale;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ricetta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String ingredienti;
    private String procedimento;


    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getIngredienti() {
        return ingredienti;
    }
    public void setIngredienti(String ingredienti) {
        this.ingredienti = ingredienti;
    }
    public String getProcedimento() {
        return procedimento;
    }
    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }


    public Long getId() {
        return id;
    }


    
}
