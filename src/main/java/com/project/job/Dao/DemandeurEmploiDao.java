package com.project.job.Dao;

import com.project.job.model.DemandeEmploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeurEmploiDao extends JpaRepository<DemandeEmploi, Long> {
}
