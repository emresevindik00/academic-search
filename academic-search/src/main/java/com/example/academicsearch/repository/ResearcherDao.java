package com.example.academicsearch.repository;

import com.example.academicsearch.model.Researcher;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface ResearcherDao extends Neo4jRepository<Researcher, Long> {
    Optional<Researcher> findByName(String name);
}
