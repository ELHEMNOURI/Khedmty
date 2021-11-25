package com.project.job.DTO;

import com.project.job.model.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class DemandeEmploiDTO {
    private Long id;
    private LocalDateTime dateDemande;
    private String telephone;
    private String address;
    private String titreDemande;
    private Long creator;
    private String status;
    private Cv cv;
    private List<Formation> formations;
    private List<Exprerience> expreriences;
    private List<Diplome> diplomes;

    public DemandeEmploi convertDtoToModel() {
        DemandeEmploi demande = new DemandeEmploi();
        demande.setId(this.id);
        demande.setDateDemande(this.dateDemande);
        demande.setTelephone(this.telephone);
        demande.setAddress(this.address);
        demande.setTitreDemande(this.titreDemande);
        demande.setCreator(this.creator);
        demande.setStatus((this.status));
        demande.setCv(this.cv);
        demande.setFormations(this.formations);
        demande.setExpreriences(this.expreriences);
        demande.setDiplomes(this.diplomes);
        return demande;
    }
}
