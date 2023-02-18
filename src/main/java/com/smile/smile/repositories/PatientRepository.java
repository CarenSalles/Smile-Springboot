package com.smile.smile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smile.smile.model.PatientModel;

public interface PatientRepository extends JpaRepository<PatientModel, String> {

    public PatientModel findByDni(String dni);

}
