package com.project.job.Dao;

import com.project.job.model.Entretien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntretienDao extends JpaRepository<Entretien,Long> {
}
