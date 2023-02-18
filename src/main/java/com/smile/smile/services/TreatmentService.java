package com.smile.smile.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smile.smile.model.TreatmentModel;
import com.smile.smile.repositories.TreatmentRepository;

@Service
public class TreatmentService {
    
    private TreatmentRepository repository;

    public TreatmentService(TreatmentRepository repository) {
        this.repository = repository;
    }
    public List<TreatmentModel> getAll() {
        return repository.findAll();
    }
    public TreatmentModel getOne(Long idTreatment){
        return repository.findById(idTreatment);
    }

}
