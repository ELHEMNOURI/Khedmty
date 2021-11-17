package com.project.job.service;

import com.project.job.DTO.ExprerienceDTO;
import com.project.job.model.Exprerience;

import java.util.List;

public interface ExperienceService {
    void createExperience(ExprerienceDTO experience);
    Exprerience findById(Long id);
    List<Exprerience> findAllExpreriences();
    void updateExprerience(Long id, ExprerienceDTO exprerience);
}
