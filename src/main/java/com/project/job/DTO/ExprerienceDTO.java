package com.project.job.DTO;

import com.project.job.model.DemandeEmploi;
import com.project.job.model.Exprerience;
import lombok.Data;

import java.util.Date;
@Data
public class ExprerienceDTO {
    private Long id;

    private String poste;

    private Date dateDebut;

    private Date dateFin;

    private String societe;

    private double salaire;

    private DemandeEmploi demandeEmploi;

    public Exprerience convertDtoToModel() {
        Exprerience exprerience = new Exprerience();

        exprerience.setId(this.id);
        exprerience.setPoste(this.poste);
        exprerience.setDateDebut(this.dateDebut);
        exprerience.setDateFin(this.dateFin);
        exprerience.setSociete(this.societe);
        exprerience.setSalaire(this.salaire);
        exprerience.setDemandeEmploi(this.demandeEmploi);

        return exprerience;
    }
}
