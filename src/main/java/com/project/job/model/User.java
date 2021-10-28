package com.project.job.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * Super Class "User"
 *
 * @author Elhem Nouri
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="typeUser")
    private String type;

    @NotEmpty(message = "Le nom utilisateur est obligatoire")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "Le mail est obligatoire")
    @Column(name="email")
    @Email(message = "Le mail doit etre valide")
    private String email;

    @NotEmpty(message = "Le pr�nom est obligatoire")
    @Column(name="firstname")
    private String firstname;

    @NotEmpty(message = "Le nom est obligatoire")
    @Column(name="lastname")
    private String lastname;

    @Column(name="matricule")
    private String matricule;

    @Pattern(regexp = "[0-9]{8}", message = "Le t�l�phone doit avoir 8 entiers positifs")
    @Column(name="telephone")
    private String telephone;

    @Column(name="address")
    private String address;

    @Column(name="enable")
    private boolean enabled = false;
}
