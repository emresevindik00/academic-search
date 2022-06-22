package com.example.academicsearch.repository;

import com.example.academicsearch.model.Publication;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;
import java.util.Optional;

public interface PublicationDao extends Neo4jRepository<Publication, Long> {
    Optional<Publication> findByName(String name);

    Optional<List<Publication>> findPublicationsByYear(String year);
}
