package com.example.academicsearch.controller;

import com.example.academicsearch.model.Publication;
import com.example.academicsearch.model.Researcher;
import com.example.academicsearch.service.ResearcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ResearcherController {

    private ResearcherService researcherService;

    @Autowired
    public ResearcherController(ResearcherService researcherService) {
        this.researcherService = researcherService;
    }

    @GetMapping("/researcher")
    public ResponseEntity<List<Researcher>> findAll() {
        return ResponseEntity.ok(researcherService.findAllResearchers());
    }

    @PostMapping("/researcher")
    public ResponseEntity<Researcher> save(@RequestBody Researcher researcher) {
        return ResponseEntity.ok(researcherService.saveResearcher(researcher));
    }

    @DeleteMapping("/researcher/{id}")
    public String delete(@PathVariable Long id) {
        researcherService.deleteResearcherById(id);
        return "publication with "+id+" deleted";
    }

    @GetMapping("/researcher/findByName/{name}")
    public ResponseEntity<Optional<Researcher>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(researcherService.findResearcherByName(name));
    }

    @GetMapping("/researcher/{id}")
    public ResponseEntity<Researcher> findResearcherById(@PathVariable Long id) {
        return ResponseEntity.ok(researcherService.findResearcherById(id));
    }

    @GetMapping("/researcher/findCommonResearcher/{id}")
    public ResponseEntity<List<Researcher>> findResearcherPartnersById(@PathVariable Long id) {
        return ResponseEntity.ok(researcherService.findResearchersPartner(id));
    }
}
