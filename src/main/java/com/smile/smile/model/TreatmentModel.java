package com.smile.smile.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "treatments")

public class TreatmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id__treatments")

    private Long id__treatment;

    @ManyToOne
    @JoinColumn(name = "dni")

    private PatientModel patient;

    public TreatmentModel(Long id__treatment, PatientModel patient) {
        this.id__treatment = id__treatment;
        this.patient = patient;
    }

    public Long getId__treatment() {
        return id__treatment;
    }

    public void setId__treatment(Long id__treatment) {
        this.id__treatment = id__treatment;
    }

    public PatientModel getPatient() {
        return patient;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

}
