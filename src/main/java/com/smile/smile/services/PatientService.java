package com.smile.smile.services;

import org.springframework.stereotype.Service;

import com.smile.smile.model.PatientModel;
import com.smile.smile.repositories.PatientRepository;

import java.util.List;

@Service
public class PatientService {

    private PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public List<PatientModel> getAll() {
        return repository.findAll();
    }

    public PatientModel getOne(String dni) {
        return repository.findByDni(dni).orElse(null);

    }

    public PatientModel save(PatientModel patientModel) {
        PatientModel patientModelSaved = repository.save(patientModel);
        return patientModelSaved;
    }
    public List <PatientModel> delete(String dni) {

        PatientModel patientToDelete = repository.findByDni(dni).orElse(null);
        repository.delete(patientToDelete);
        return repository.findAll();
}}
