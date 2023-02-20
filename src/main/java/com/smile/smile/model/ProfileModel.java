package com.smile.smile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "profiles")

public class ProfileModel {
    @OneToOne
    private PatientModel dni;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile")
    private Long idProfile;

    private String name;
    private String surname;
    private int phoneNumber;
    private String adress;
    private String city;

    public ProfileModel(){}
    
    public ProfileModel(PatientModel dni, Long idProfile, String name, String surname, int phoneNumber, String adress,
            String city) {
        this.dni = dni;
        this.idProfile = idProfile;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.city = city;
    }

    public PatientModel getDni() {
        return dni;
    }

    public void setDni(PatientModel dni) {
        this.dni = dni;
    }

    public Long getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Long idProfile) {
        this.idProfile = idProfile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
