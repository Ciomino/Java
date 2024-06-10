package com.example.testFinaleprova2;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaintingRepository extends JpaRepository<Painting, Long> {
    List<Painting> findByAuthor(String author);
    List<Painting> findByCreationYear(int creationYear);
}
