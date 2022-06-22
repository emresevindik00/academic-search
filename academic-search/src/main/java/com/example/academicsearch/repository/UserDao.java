package com.example.academicsearch.repository;

import com.example.academicsearch.model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserDao extends Neo4jRepository<User, Long> {
    User findByEmail(String email);
    //User findById(Long id);
}
