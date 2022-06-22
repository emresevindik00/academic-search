package com.example.academicsearch.service.impl;

import com.example.academicsearch.model.Publication;
import com.example.academicsearch.repository.PublicationDao;
import com.example.academicsearch.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PublicationManager implements PublicationService {

    private final PublicationDao publicationDao;

    @Autowired
    public PublicationManager(PublicationDao publicationDao) {
        this.publicationDao = publicationDao;
    }

    @Override
    public List<Publication> findAllPublications() {
        return Optional.ofNullable(publicationDao.findAll())
                .orElseThrow(() -> new RuntimeException("Not found"));

    }

    @Override
    public Publication save(Publication publication) {
        return publicationDao.save(publication);
    }

    @Override
    public Publication findById(Long id) {
        return publicationDao.findById(id).orElseThrow(() -> new RuntimeException("Publication "+ id + " not found"));
    }

    @Override
    public void deleteById(Long id) {
        if(!publicationDao.existsById(id)) {
            new RuntimeException("Publication" + id + " not found");
        }
        publicationDao.deleteById(id);
    }

    @Override
    public Optional<Publication> findByName(String name) {
        return Optional.ofNullable
                (publicationDao.findByName(name).orElseThrow(()
                -> new RuntimeException("Publication "+name+" not found")));
    }

    @Override
    public List<Publication> findPublicationByYear(String year) {
        return publicationDao.findPublicationsByYear(year).orElseThrow(() -> new RuntimeException("Not Found"));

    }


}
