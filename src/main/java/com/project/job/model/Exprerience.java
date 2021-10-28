package com.project.job.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exprerience {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private String poste;

    private Date dateDebut;

    private Date dateFin;

    private String societe;

    private double salaire;

    @ManyToOne
    @JoinColumn(name="demande_emploi_id", nullable = false)
    private DemandeEmploi demandeEmploi;


}
