package com.project.job.Dao;

import com.project.job.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationDao extends JpaRepository<Formation, Long> {
}
