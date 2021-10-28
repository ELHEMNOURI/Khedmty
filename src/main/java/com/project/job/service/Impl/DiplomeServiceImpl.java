package com.project.job.service.Impl;

import com.project.job.Dao.DiplomeDao;
import com.project.job.model.Diplome;
import com.project.job.service.DiplomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiplomeServiceImpl implements DiplomeService {


    @Autowired
    DiplomeDao diplomeDao;

    @Override
    public List<Diplome> findAllDiplome() {
        return diplomeDao.findAll();
    }
}
