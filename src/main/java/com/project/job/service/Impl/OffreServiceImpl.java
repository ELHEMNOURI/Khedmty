package com.project.job.service.Impl;

import com.project.job.DTO.OffreDTO;
import com.project.job.Dao.OffreDao;
import com.project.job.enums.StatusOffre;
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
        offre1.setStatus(StatusOffre.ENATTENTE.getName());
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

    @Override
    public List<Offre> findAllByStatus(String status){
        return offreDao.findAllByStatus(status);
    }

    @Override
    public Offre updateOffre(Long id, OffreDTO offreDTO){
        Offre oldOffre = findById(id);

        if(oldOffre != null && offreDTO != null) {
            if (offreDTO.getStatus().equals(StatusOffre.VALIDER.getName())) {
                oldOffre.setStatus(StatusOffre.VALIDER.getName());
            } else if (offreDTO.getStatus().equals(StatusOffre.INVALIDE.getName())) {
                oldOffre.setStatus(StatusOffre.INVALIDE.getName());
            }
        }
        return offreDao.save(oldOffre);
    }

}
