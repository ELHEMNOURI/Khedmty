package com.project.job.service.Impl;
import com.project.job.DTO.FormationDTO;
import com.project.job.Dao.FormationDao;
import com.project.job.model.DemandeEmploi;
import com.project.job.model.Formation;
import com.project.job.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service

public class FormationServiceImpl implements FormationService {
    @Autowired
    FormationDao formationDao;

    @Override
    public void createFormation(FormationDTO formation) {
        Formation form=new Formation();

        form.setDescription(formation.getDescription());
        form.setDateformation(formation.getDateformation());
        form.setNomFormation(formation.getNomFormation());
        formationDao.save(form);
    }

    @Override
    public Formation findById(Long id)
    {
        return formationDao.findById(id).isPresent() ? formationDao.findById(id).get() : null ;
    }

    @Override
    public List<Formation> findAllFormations() {
        return formationDao.findAll();
    }

    @Override
    public void updateFormation(Long id, FormationDTO formation) {
        Formation f = formationDao.findById(id).isPresent() ? formationDao.findById(id).get() : null ;
        f.setNomFormation(formation.getNomFormation());
        f.setDateformation(formation.getDateformation());
        f.setDescription(formation.getDescription());
        f.setDemandeEmploi(formation.getDemandeEmploi());
        formationDao.save(f);
    }

}

