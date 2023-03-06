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

    private String dni;

    public PatientModel() {
    }

    public PatientModel(String dni) {
        this.dni = dni;
    }

    public String getDniPatient() {
        return dni;
    }

    public void setDniPatient(String dni) {
        this.dni = dni;
    }

    public PatientModel orElse(Object object) {
        return null;
    }

    public PatientModel orElseThrow() {
        return null;
    }

}