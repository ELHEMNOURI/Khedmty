package com.project.job.Dao;

import com.project.job.model.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiplomeDao extends JpaRepository<Diplome, Long> {
}
