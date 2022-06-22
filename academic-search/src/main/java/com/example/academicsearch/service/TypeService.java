package com.example.academicsearch.service;

import com.example.academicsearch.model.Type;

import java.util.List;

public interface TypeService {
    List<Type> findAllTypes();
    Type save(Type type);
    Type findById(Long id);
    void deleteById(Long id);
}
