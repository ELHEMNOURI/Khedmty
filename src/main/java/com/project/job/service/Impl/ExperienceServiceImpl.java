package com.project.job.service.Impl;

import com.project.job.DTO.ExprerienceDTO;
import com.project.job.Dao.ExperienceDao;
import com.project.job.model.Exprerience;
import com.project.job.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    ExperienceDao experienceDao;


    @Override
    public void createExperience(ExprerienceDTO experience) {
        Exprerience exp = new Exprerience();

        exp.setPoste(experience.getPoste());
        exp.setDateDebut(experience.getDateDebut());
        exp.setDateFin(experience.getDateFin());
        exp.setSociete(experience.getSociete());
        exp.setSalaire(experience.getSalaire());
        exp.setDemandeEmploi(experience.getDemandeEmploi());
        experienceDao.save(exp);
    }

    @Override
    public Exprerience findById(Long id) {
        return experienceDao.findById(id).isPresent() ? experienceDao.findById(id).get() : null ;
    }

    @Override
    public List<Exprerience> findAllExpreriences() {
        return experienceDao.findAll();
    }

    @Override
    public void updateExprerience(Long id, ExprerienceDTO experience) {

        Exprerience exp = experienceDao.findById(id).isPresent() ? experienceDao.findById(id).get() : null ;
        exp.setPoste(experience.getPoste());
        exp.setDateDebut(experience.getDateDebut());
        exp.setDateFin(experience.getDateFin());
        exp.setSociete(experience.getSociete());
        exp.setSalaire(experience.getSalaire());
        exp.setDemandeEmploi(experience.getDemandeEmploi());
        experienceDao.save(exp);
    }
}
