package com.project.job.DTO;

import com.project.job.model.DemandeEmploi;
import com.project.job.model.Formation;
import lombok.Data;

import java.util.Date;
@Data

public class FormationDTO {
    private Long id;

    private String nomFormation;

    private Date dateformation;

    private String Description;
    private DemandeEmploi demandeEmploi;

    public Formation convertDtoToModel() {
        Formation formation = new Formation();
        formation.setId(this.id);
        formation.setNomFormation(this.nomFormation);
        formation.setDateformation(this.dateformation);
        formation.setDescription(this.Description);
        formation.setDemandeEmploi(this.demandeEmploi);

        return formation;

    }
}
