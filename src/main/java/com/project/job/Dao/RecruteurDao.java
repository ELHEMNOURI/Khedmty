package com.project.job.Dao;

import com.project.job.model.Recruteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruteurDao extends  JpaRepository <Recruteur, Long>{
}
