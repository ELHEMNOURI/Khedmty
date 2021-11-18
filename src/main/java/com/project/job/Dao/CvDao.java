package com.project.job.Dao;

import com.project.job.model.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvDao extends JpaRepository<Cv, Long> {
}
