package com.example.esercizio_jpa_h2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/libri")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> getAllLibri(){
        return libroService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id){
        Optional<Libro> libro = libroService.findById(id);
        if(libro.isPresent()){
            return ResponseEntity.ok(libro.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public Libro createLibro(@RequestBody Libro libro){
        return libroService.save(libro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @RequestBody Libro libroDetails) {
        Optional<Libro> libroOptional = libroService.findById(id);
        if (libroOptional.isPresent()) {
            Libro libro = libroOptional.get();
            libro.setTitolo(libroDetails.getTitolo());
            libro.setAutore(libroDetails.getAutore());
            libro.setPrezzo(libroDetails.getPrezzo());
            return ResponseEntity.ok(libroService.save(libro));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        Optional<Libro> libro = libroService.findById(id);
        if (libro.isPresent()) {
            libroService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
