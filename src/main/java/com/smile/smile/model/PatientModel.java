package com.smile.smile.model;

import javax.persistence.Column;
<<<<<<< HEAD
import javax.persistence.Entity;
=======

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
>>>>>>> 4dad59c980f9ff3173112f20718580a83e26fe11
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class PatientModel {

    @Id
<<<<<<< HEAD
    @Column(name = "dni")

    private String dniPatient;

    public String getDniPatient() {
        return dniPatient;
    }

    public void setDniPatient(String dniPatient) {
        this.dniPatient = dniPatient;
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id__patients")
    public Long id;

    public PatientModel(Long id) {
        this.id = id;
>>>>>>> 4dad59c980f9ff3173112f20718580a83e26fe11
    }

}