package com.project.job.service.Impl;

import com.project.job.DTO.DemandeEmploiDTO;
import com.project.job.Dao.DemandeEmploiDao;
import com.project.job.enums.DemandeEmploiStatus;
import com.project.job.model.DemandeEmploi;
import com.project.job.service.DemandeEmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeEmploiServiceImpl implements DemandeEmploiService {

    @Autowired
    DemandeEmploiDao demandeEmploiDao;

    @Override
    public List<DemandeEmploi> findAllDemandes() {
        return demandeEmploiDao.findAll();
    }

    @Override
    public void createDemandeEmploi(DemandeEmploiDTO demande) {
        DemandeEmploi demandeEmploi = new DemandeEmploi();

        demandeEmploi.setId(demande.getId());
        demandeEmploi.setDateDemande(demande.getDateDemande());
        demandeEmploi.setTelephone(demande.getTelephone());
        demandeEmploi.setAddress(demande.getAddress());
        demandeEmploi.setTitreDemande(demande.getTitreDemande());
        demandeEmploi.setCreator(demande.getCreator());
        demandeEmploi.setStatus(DemandeEmploiStatus.ENATTENTE.getName());
        demandeEmploi.setCv(demande.getCv());
        demandeEmploi.setFormations(demande.getFormations());
        demandeEmploi.setExpreriences(demande.getExpreriences());
        demandeEmploi.setDiplomes(demande.getDiplomes());

        demandeEmploiDao.save(demandeEmploi);
    }

    @Override
    public void updateDemandeEmploi(Long id, DemandeEmploiDTO demande) {
        DemandeEmploi demandeEmploi = demandeEmploiDao.findById(id).isPresent() ? demandeEmploiDao.findById(id).get() : null;

        demandeEmploi.setId(demande.getId());
        demandeEmploi.setDateDemande(demande.getDateDemande());
        demandeEmploi.setTelephone(demande.getTelephone());
        demandeEmploi.setAddress(demande.getAddress());
        demandeEmploi.setTitreDemande(demande.getTitreDemande());
        demandeEmploi.setCreator(demande.getCreator());
        demandeEmploi.setCv(demande.getCv());
        demandeEmploi.setFormations(demande.getFormations());
        demandeEmploi.setExpreriences(demande.getExpreriences());
        demandeEmploi.setDiplomes(demande.getDiplomes());

        if(demandeEmploi != null && demande != null){
            if(demande.getStatus().equals(DemandeEmploiStatus.VALIDER.getName())){
                demandeEmploi.setStatus(DemandeEmploiStatus.VALIDER.getName());
            }else if(demande.getStatus().equals(DemandeEmploiStatus.INVALIDE.getName())){
                demandeEmploi.setStatus(DemandeEmploiStatus.INVALIDE.getName());
            }
        }

        demandeEmploiDao.save(demandeEmploi);
    }

    @Override
    public List<DemandeEmploi> findAllStatus(String sattus) {
        return null;
    }
}
