package com.project.job.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.job.DTO.RecruteurDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Child Class "Recruteur"
 *
 * @author Elhem Nouri
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Recruteur")
@Table(name="recruteurs")
@Entity
public class Recruteur extends User{

    private String refRecruteur;

    @ManyToOne
    @JoinColumn(name="offre_id")
    private Offre offre;

    public RecruteurDTO convertRecruteurToDto(){
        RecruteurDTO recruteurDTO = new RecruteurDTO();
        User user = new User();
        recruteurDTO.setId(user.getId());
        recruteurDTO.setFirstname(user.getFirstname());

        return recruteurDTO;
    }
}
