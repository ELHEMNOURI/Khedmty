package com.project.job.service;

import com.project.job.DTO.FormationDTO;
import com.project.job.model.Formation;

import java.util.List;

public interface FormationService {
    void createFormation(FormationDTO formation);
    Formation findById(Long id);
    List<Formation> findAllFormations();
    void updateFormation(Long id, FormationDTO formation);

}
