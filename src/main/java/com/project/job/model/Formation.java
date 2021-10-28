package com.project.job.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private String nomFormation;

    private Date dateformation;

    private String Description;

    @ManyToOne
    @JoinColumn(name="demande_emploi_id", nullable = false)
    private DemandeEmploi demandeEmploi;

}
