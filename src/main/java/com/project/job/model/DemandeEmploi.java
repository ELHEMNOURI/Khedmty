package com.project.job.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.job.DTO.DemandeEmploiDTO;
import com.project.job.DTO.ExprerienceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DemandeEmploi {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @CreationTimestamp
    @Column(name = "date_demande")
    private LocalDateTime dateDemande;

    @Pattern(regexp = "[0-9]{8}", message = "Le t�l�phone doit avoir 8 entiers positifs")
    @Column(name="telephone")
    private String telephone;

    @Column(name="address")
    private String address;

    @Column(name="titre")
    private String titreDemande;

    private Long creator;

    @OneToOne
    private Cv cv;

    @OneToMany(mappedBy = "demandeEmploi", cascade= CascadeType.ALL)
    @JsonIgnore
    private List<Formation> formations;

    @OneToMany(mappedBy = "demandeEmploi", cascade= CascadeType.ALL)
    @JsonIgnore
    private List<Exprerience> expreriences;

    @OneToMany(mappedBy = "demandeEmploi", cascade= CascadeType.ALL)
    @JsonIgnore
    private List<Diplome> diplomes;

    public DemandeEmploiDTO convertModelDTO () {
        DemandeEmploiDTO demandeEmploiDTO = new DemandeEmploiDTO();
        demandeEmploiDTO.setId(this.id);
        demandeEmploiDTO.setDateDemande(this.dateDemande);
        demandeEmploiDTO.setTelephone(this.telephone);
        demandeEmploiDTO.setAddress(this.address);
        demandeEmploiDTO.setTitreDemande(this.titreDemande);
        demandeEmploiDTO.setCreator(this.creator);
        demandeEmploiDTO.setCv(this.cv);
        demandeEmploiDTO.setFormations(this.formations);
        demandeEmploiDTO.setExpreriences(this.expreriences);
        demandeEmploiDTO.setDiplomes(this.diplomes);

        return  demandeEmploiDTO;
    }

}
