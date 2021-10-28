package com.project.job.service.Impl;

import com.project.job.Dao.CvDao;
import com.project.job.model.Cv;
import com.project.job.service.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvServiceImpl implements CvService {

    @Autowired
    CvDao cvDao;

    @Override
    public List<Cv> findAllCv() {
        return cvDao.findAll();
    }
}
