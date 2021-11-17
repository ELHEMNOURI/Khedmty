package com.project.job.model;

import com.project.job.DTO.CvDTO;
import com.project.job.DTO.OffreDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cv {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private String cv;

    public CvDTO convertModelDTO (){
        CvDTO cvDTO = new CvDTO();

        cvDTO.setId(this.id);
        cvDTO.setCv(this.cv);

        return cvDTO;
    }

}
