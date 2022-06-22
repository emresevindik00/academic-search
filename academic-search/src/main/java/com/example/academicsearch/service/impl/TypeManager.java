package com.example.academicsearch.service.impl;

import com.example.academicsearch.model.Type;
import com.example.academicsearch.repository.TypeDao;
import com.example.academicsearch.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeManager implements TypeService {

    private TypeDao typeDao;

    @Autowired
    public TypeManager(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    @Override
    public List<Type> findAllTypes() {
        return Optional.ofNullable(typeDao.findAll()).orElseThrow(() -> new RuntimeException("There is no type"));
    }

    @Override
    public Type save(Type type) {
        return typeDao.save(type);
    }

    @Override
    public Type findById(Long id) {
        return typeDao.findById(id).orElseThrow(() -> new RuntimeException("Publication "+ id + " not found"));
    }

    @Override
    public void deleteById(Long id) {
        if(!typeDao.existsById(id)) {
            throw new RuntimeException();
        }
        typeDao.deleteById(id);
    }
}
