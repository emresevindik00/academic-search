package com.example.academicsearch.repository;

import com.example.academicsearch.model.Type;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TypeDao extends Neo4jRepository<Type, Long> {
}
