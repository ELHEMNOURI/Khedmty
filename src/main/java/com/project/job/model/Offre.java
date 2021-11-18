package com.project.job.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.job.DTO.OffreDTO;
import com.project.job.DTO.RecruteurDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Offre {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @CreationTimestamp
    @Column(name = "create_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private Date updatedAt;

    private Long creator;

    private String description;

    private String status;

    @OneToMany
    @JsonIgnore
    private List<Recruteur> recruteurs;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "pivot_offre_demandeur", joinColumns = {
            @JoinColumn(name = "offre_id") }, inverseJoinColumns = {
            @JoinColumn(name = "demandeur_id") })
    @JsonIgnoreProperties(value={ "offres" }, allowSetters= true)
    private Set<Demandeur> demandeurs = new HashSet<>();

    /**
     * Method for Convert Model to DTO
     */
    public OffreDTO convertModelDTO (){
        OffreDTO offreDTO = new OffreDTO();

        offreDTO.setId(this.id);
        offreDTO.setCreatedAt(this.createdAt);
        offreDTO.setCreator(this.creator);
        offreDTO.setDescription(this.description);
        offreDTO.setUpdatedAt(this.updatedAt);
        offreDTO.setStatus(this.status);

        /*if (this.demandeurs != null) {
            Set<RecruteurDTO> v = new HashSet<>();
            this.demandeurs.forEach( demandeur -> {
                d.add(demandeur.createDemandeurDTO());
            });
            offreDTO.setDemandeurs(d);
        }*/


        return offreDTO;
    }
}
