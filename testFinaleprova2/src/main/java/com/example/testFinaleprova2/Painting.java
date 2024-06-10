package com.example.testFinaleprova2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Painting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private int creationYear; 

    // Costruttore vuoto richiesto da JPA
    public Painting() {
    }

    // Costruttore con tutti i campi tranne l'id, che verrà generato automaticamente
    public Painting(String title, String author, int creationYear) {
        this.title = title;
        this.author = author;
        this.creationYear = creationYear;
    }

    // Getters e setters
    // Implementa i metodi getter e setter per tutti i campi
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }
    
}
