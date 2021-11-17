package com.project.job.service;

import com.project.job.DTO.CvDTO;
import com.project.job.model.Cv;

import java.util.List;

public interface CvService {
    void createCV(CvDTO cv);
    Cv findById(Long id);
    List<Cv> findAllCv();
    void updateCV(Long id, CvDTO cv);
}
