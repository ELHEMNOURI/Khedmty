package com.project.job.model;

import com.project.job.DTO.DiplomeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diplome {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private String titreDiplome;

    private Date annee;

    private String ecole;

    private String mention;

    @ManyToOne
    @JoinColumn(name="demande_emploi_id", nullable = false)
    private DemandeEmploi demandeEmploi;

    public DiplomeDTO convertModelDTO () {
        DiplomeDTO diplomeDTO = new DiplomeDTO();

        diplomeDTO.setId(this.id);
        diplomeDTO.setTitreDiplome(this.titreDiplome);
        diplomeDTO.setAnnee(this.annee);
        diplomeDTO.setEcole(this.ecole);
        diplomeDTO.setMention(this.mention);
        diplomeDTO.setDemandeEmploi(this.demandeEmploi);

        return diplomeDTO;
    }

}
