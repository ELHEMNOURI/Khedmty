package com.project.job.DTO;


import com.project.job.model.Demandeur;
import com.project.job.model.Offre;
import com.project.job.model.Recruteur;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
public class OffreDTO {

   private Long id;

   private Date createdAt;

   private Date updatedAt;

   private Long creator;

   private String description;

   private Recruteur recruteur;

   private String status;
   private Set<Demandeur> demandeurs;

   public Offre convertDtoToModel(){
      Offre offre = new Offre();

      offre.setId(this.id);
      offre.setCreatedAt(this.createdAt);
      offre.setDescription(this.description);
      //offre.setRecruteur(this.recruteur);
      offre.setUpdatedAt(this.updatedAt);
      offre.setCreator(this.creator);
      offre.setStatus(this.status);

      return offre;
   }

}