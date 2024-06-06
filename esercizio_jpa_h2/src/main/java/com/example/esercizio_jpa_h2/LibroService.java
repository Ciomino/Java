package com.example.esercizio_jpa_h2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> findAll(){
        return libroRepository.findAll();
    }

    public Optional<Libro> findById(Long id){
        return libroRepository.findById(id);
    }

    public Libro save(Libro libro){
        return libroRepository.save(libro);
    }

    public void deleteById(Long id){
        libroRepository.deleteById(id);
    }
    
}
