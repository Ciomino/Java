package com.example.progettoIncrementale;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RicettaService {

    @Autowired
    private RicettaRepository ricettaRepository;

    public List<Ricetta> findAll() {
        return ricettaRepository.findAll();
    }

    public Optional<Ricetta> findById(Long id) {
        return ricettaRepository.findById(id);
    }

    public Ricetta save(Ricetta ricetta) {
        return ricettaRepository.save(ricetta);
    }

    public void deleteById(Long id) {
        ricettaRepository.deleteById(id);
    }

    public Ricetta updateRicetta(Long id, Ricetta ricettaDetails) {
        Optional<Ricetta> optionalRicetta = ricettaRepository.findById(id);
        if (optionalRicetta.isPresent()) {
            Ricetta existingRicetta = optionalRicetta.get();
            existingRicetta.setNome(ricettaDetails.getNome());
            existingRicetta.setIngredienti(ricettaDetails.getIngredienti());
            existingRicetta.setProcedimento(ricettaDetails.getProcedimento());
            return ricettaRepository.save(existingRicetta);
        } else {
            throw new RuntimeException("Ricetta not found with id " + id);
        }
    }
}
