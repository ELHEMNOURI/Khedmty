package com.project.job.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Child Class "Demandeur"
 *
 * @author Elhem Nouri
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Demandeur")
@Entity
@Table(name="demandeurs")
public class Demandeur extends User{

    private String redDemandeur;

    @ManyToMany(mappedBy = "demandeurs")
    @JsonIgnore
    @JsonIgnoreProperties(value = { "demandeurs" }, allowSetters = true)
    private Set<Offre> offres;

    /*public DemandeurDTO createDemandeurDTO(){

    }*/
}
