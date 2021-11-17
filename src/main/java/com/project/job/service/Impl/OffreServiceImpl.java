package com.project.job.service.Impl;

import com.project.job.DTO.OffreDTO;
import com.project.job.Dao.OffreDao;
import com.project.job.model.Offre;
import com.project.job.service.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffreServiceImpl implements OffreService {

    @Autowired
    private OffreDao offreDao;

    @Override
    public void createOffre(OffreDTO offre) {
        Offre offre1 = new Offre();

        offre1.setDescription(offre.getDescription());
       // offre1.setRecruteur(offre.getRecruteur());
        offre1.setCreator(offre.getCreator());
        offre1.setCreatedAt(offre.getCreatedAt());
        offre1.setUpdatedAt(offre.getUpdatedAt());
        offreDao.save(offre1);
    }

    @Override
    public Offre findById(Long id) {
        return offreDao.findById(id).isPresent() ? offreDao.findById(id).get() : null ;
    }

    @Override
    public List<Offre> findAllOffres() {
        return offreDao.findAll();
    }


}
