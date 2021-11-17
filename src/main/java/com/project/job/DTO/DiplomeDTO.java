package com.project.job.DTO;

import com.project.job.model.Diplome;
import com.project.job.model.DemandeEmploi;
import lombok.Data;

import java.util.Date;
@Data
public class DiplomeDTO {
    private Long id;

    private String titreDiplome;

    private Date annee;

    private String ecole;

    private String mention;

    private DemandeEmploi demandeEmploi;

    public Diplome convertDtoToModel(){
        Diplome diplome = new Diplome();

        diplome.setId(this.id);
        diplome.setTitreDiplome(this.titreDiplome);
        diplome.setAnnee(this.annee);
        diplome.setEcole(this.ecole);
        diplome.setMention(this.mention);
        diplome.setDemandeEmploi(this.demandeEmploi);

        return diplome;
    }
}
