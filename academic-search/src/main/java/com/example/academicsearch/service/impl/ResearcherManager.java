package com.example.academicsearch.service.impl;

import com.example.academicsearch.model.Publication;
import com.example.academicsearch.model.Researcher;
import com.example.academicsearch.repository.PublicationDao;
import com.example.academicsearch.repository.ResearcherDao;
import com.example.academicsearch.service.ResearcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResearcherManager implements ResearcherService {

    private final ResearcherDao researcherDao;
    private final PublicationDao publicationDao;

    @Autowired
    public ResearcherManager(ResearcherDao researcherDao, PublicationDao publicationDao) {
        this.researcherDao = researcherDao;
        this.publicationDao = publicationDao;
    }

    @Override
    public List<Researcher> findAllResearchers() {
        return Optional.ofNullable(researcherDao.findAll())
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public Researcher saveResearcher(Researcher researcher) {
        return researcherDao.save(researcher);
    }

    @Override
    public Researcher findResearcherById(Long id) {
        return researcherDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Researcher "+id+" not found"));
    }

    @Override
    public void deleteResearcherById(Long id) {
        if(!researcherDao.existsById(id)) {
            throw new RuntimeException("Researcher "+id+" not found");
        }
        researcherDao.deleteById(id);
    }

    @Override
    public Optional<Researcher> findResearcherByName(String name) {
        return Optional.ofNullable
                (researcherDao.findByName(name))
                .orElseThrow(() -> new RuntimeException(name+" researcher not found."));
    }

    @Override
    public List<Researcher> findResearchersPartner(Long id) {
         List<Publication> publications = researcherDao.findById(id).get().getPublications();
         List<Researcher> commonResearcher = new ArrayList<>();
         List<Researcher> researchers = researcherDao.findAll();


        for (Researcher researcher:researchers) {
            if(researcher.getPublications().stream().anyMatch(publications::contains)) {
                commonResearcher.add(researcher);
            }
        }

        commonResearcher.remove(researcherDao.findById(id).get());
         return commonResearcher;
    }
}
