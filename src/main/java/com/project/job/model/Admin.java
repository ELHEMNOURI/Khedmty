package com.project.job.model;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Child Class "Admin"
 *
 * @author Elhem Nouri
 */
@Data
@AllArgsConstructor
@Entity
@DiscriminatorValue("Admin")
public class Admin extends User {
}
