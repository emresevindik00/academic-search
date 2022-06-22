package com.example.academicsearch.controller;

import com.example.academicsearch.model.Publication;
import com.example.academicsearch.service.PublicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
@CrossOrigin
public class PublicationController {

    private PublicationService publicationService;

    @Autowired
    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping("/publications")
    public ResponseEntity<List<Publication>> findAll() {
        return ResponseEntity.ok(publicationService.findAllPublications());
    }

    @PostMapping("/publications")
    public ResponseEntity<Publication> save(@RequestBody Publication publication) {
        return ResponseEntity.ok(publicationService.save(publication));
    }

    @DeleteMapping("/publications/{id}")
    public String delete(@PathVariable Long id) {
        publicationService.deleteById(id);
        log.info("Publication deleted by id");
        return "publication with "+id+" deleted";
    }

    @GetMapping("/publications/findByName/{name}")
    public ResponseEntity<Optional<Publication>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(publicationService.findByName(name));
    }

    @GetMapping("/publications/findByYear/{year}")
    public ResponseEntity<List<Publication>> findPublicationByYear(@PathVariable String year) {
        return ResponseEntity.ok(publicationService.findPublicationByYear(year));
    }

    @GetMapping("/publications/{id}")
    public ResponseEntity<Publication> findPublicationById(@PathVariable Long id) {
        return ResponseEntity.ok(publicationService.findById(id));
    }
}
