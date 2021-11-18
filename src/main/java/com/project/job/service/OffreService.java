package com.project.job.service;

import com.project.job.DTO.OffreDTO;
import com.project.job.model.Offre;

import java.util.List;

public interface OffreService {

    void createOffre(OffreDTO offre);
    Offre findById(Long id);
    List<Offre> findAllOffres();
    List<Offre> findAllByStatus(String status);
    Offre updateOffre(Long id, OffreDTO offreDTO);
}
