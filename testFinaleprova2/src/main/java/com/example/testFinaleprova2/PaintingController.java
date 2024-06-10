package com.example.testFinaleprova2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paintings")
public class PaintingController {
    @Autowired
    private PaintingRepository paintingRepository;

    @GetMapping
    public List<Painting> getAllPaintings() {
        return paintingRepository.findAll();
    }

    @PostMapping
    public Painting addPainting(@RequestBody Painting painting) {
        return paintingRepository.save(painting);
    }

    @GetMapping("/byAuthor/{author}")
    public List<Painting> getPaintingsByAuthor(@PathVariable String author) {
        return paintingRepository.findByAuthor(author);
    }

    @GetMapping("/byYear/{creationYear}")
    public List<Painting> getPaintingsByYear(@PathVariable int creationYear) {
        return paintingRepository.findByCreationYear(creationYear);
    }
}
