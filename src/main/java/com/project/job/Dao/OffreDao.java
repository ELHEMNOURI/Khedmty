package com.project.job.Dao;

import com.project.job.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffreDao extends JpaRepository<Offre, Long> {

    List<Offre> findAllByStatus(String status);

}
