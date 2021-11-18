package com.project.job.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class RecruteurDTO {

    private String refRecruteur;

    private Long id;

    private String type;

    private String username;

    private String email;

    private String firstname;

    private String lastname;

    private String matricule;

    private String telephone;

    private String address;

    private boolean enabled = false;
}
