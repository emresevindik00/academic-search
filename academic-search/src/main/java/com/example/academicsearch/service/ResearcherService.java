package com.example.academicsearch.service;

import com.example.academicsearch.model.Publication;
import com.example.academicsearch.model.Researcher;

import java.util.List;
import java.util.Optional;

public interface ResearcherService {
    List<Researcher> findAllResearchers();

    Researcher saveResearcher(Researcher researcher);

    Researcher findResearcherById(Long id);

    void deleteResearcherById(Long id);

    Optional<Researcher> findResearcherByName(String name);

    List<Researcher> findResearchersPartner(Long id);
}
