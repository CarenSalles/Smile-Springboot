package com.smile.smile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class PatientModel {

    @Id
    @Column(name = "dni")

    private String dniPatient;

    public String getDniPatient() {
        return dniPatient;
    }

    public void setDniPatient(String dniPatient) {
        this.dniPatient = dniPatient;
    }

}