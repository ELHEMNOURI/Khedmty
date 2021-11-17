package com.project.job.Dao;

import com.project.job.model.Demandeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeurDao extends JpaRepository<Demandeur, Long> {
}
