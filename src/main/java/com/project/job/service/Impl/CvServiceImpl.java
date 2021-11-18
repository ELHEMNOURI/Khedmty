package com.project.job.service.Impl;

import com.project.job.DTO.CvDTO;
import com.project.job.Dao.CvDao;
import com.project.job.model.Cv;
import com.project.job.service.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvServiceImpl implements CvService {

    @Autowired
    private CvDao cvDao;

    @Override
    public void createCV(CvDTO cv) {
        Cv cv1 = new Cv();

        cv1.setCv(cv.getCv());
        cvDao.save(cv1);
    }

    @Override
    public Cv findById(Long id) {
        return cvDao.findById(id).isPresent() ? cvDao.findById(id).get() : null ;
    }

    @Override
    public List<Cv> findAllCv() {

        return cvDao.findAll();
    }

    @Override
    public void updateCV(Long id, CvDTO cv) {
        Cv cv1 = cvDao.findById(id).isPresent() ? cvDao.findById(id).get() : null;
        cv1.setCv(cv.getCv());
        cvDao.save(cv1);
    }
}
