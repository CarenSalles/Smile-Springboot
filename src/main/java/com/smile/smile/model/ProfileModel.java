package com.smile.smile.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "profiles")

public class ProfileModel {
    @Id
    private Long id;

    @OneToOne

    private PatientModel patient;

}
