package com.project.job.service.Impl;

import com.project.job.DTO.DiplomeDTO;
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
    public void createDiplome(DiplomeDTO diplome) {
        Diplome dip = new Diplome();

        dip.setTitreDiplome(diplome.getTitreDiplome());
        dip.setAnnee(diplome.getAnnee());
        dip.setEcole(diplome.getEcole());
        dip.setMention(diplome.getMention());
        dip.setDemandeEmploi(diplome.getDemandeEmploi());
        diplomeDao.save(dip);
    }

    @Override
    public Diplome findById(Long id) {

        return diplomeDao.findById(id).isPresent() ? diplomeDao.findById(id).get() : null ;
    }

    @Override
    public List<Diplome> findAllDiplome() {

        return diplomeDao.findAll();
    }

    @Override
    public void updateDiplome(Long id, DiplomeDTO diplome) {

        Diplome dip = diplomeDao.findById(id).isPresent() ? diplomeDao.findById(id).get() : null;
        dip.setTitreDiplome(diplome.getTitreDiplome());
        dip.setAnnee(diplome.getAnnee());
        dip.setEcole(diplome.getEcole());
        dip.setMention(diplome.getMention());
        dip.setDemandeEmploi(diplome.getDemandeEmploi());
        diplomeDao.save(dip);
    }
}
