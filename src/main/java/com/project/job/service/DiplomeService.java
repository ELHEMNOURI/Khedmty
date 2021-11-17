package com.project.job.service;

import com.project.job.DTO.DiplomeDTO;
import com.project.job.model.Diplome;

import java.util.List;

public interface DiplomeService {
    void createDiplome(DiplomeDTO diplome);
    Diplome findById(Long id);
    List<Diplome> findAllDiplome();
    void updateDiplome(Long id, DiplomeDTO diplome);
}
