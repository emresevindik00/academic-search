package com.example.academicsearch.service;

import com.example.academicsearch.model.Publication;
import java.util.List;
import java.util.Optional;


public interface PublicationService {
    List<Publication> findAllPublications();
    Publication save(Publication publication);
    Publication findById(Long id);
    void deleteById(Long id);
    Optional<Publication> findByName(String name);

    List<Publication> findPublicationByYear(String year);
}
