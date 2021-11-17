package com.project.job.DTO;

import com.project.job.model.Cv;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CvDTO {
    private Long id;
    private String cv;

    public Cv convertDtoToModel(){
        Cv cv = new Cv();

        cv.setId(this.id);
        cv.setCv(this.cv);

        return cv;
    }
}
