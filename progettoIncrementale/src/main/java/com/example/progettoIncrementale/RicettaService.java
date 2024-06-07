package com.example.progettoIncrementale;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RicettaService {
    @Autowired
    private RicettaRepository ricettaRepository;

    public List<Ricetta> findAll(){
        return ricettaRepository.findAll();
    }

    public Optional<Ricetta> findById(Long id){
        return ricettaRepository.findById(id);
    }

    public Ricetta save(Ricetta Ricetta){
        return ricettaRepository.save(Ricetta);
    }

    public void deleteById(Long id){
        ricettaRepository.deleteById(id);
    }
}
