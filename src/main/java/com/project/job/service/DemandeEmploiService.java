package com.project.job.service;

import com.project.job.DTO.DemandeEmploiDTO;
import com.project.job.model.DemandeEmploi;

import java.util.List;

public interface DemandeEmploiService {
    List<DemandeEmploi> findAllDemandes();
    void createDemandeEmploi(DemandeEmploiDTO demande);
    void updateDemandeEmploi(Long id, DemandeEmploiDTO demande);
}
