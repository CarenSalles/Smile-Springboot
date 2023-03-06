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

    public TreatmentModel findById(Long idTreatment) {
        return repository.findById(idTreatment).orElse(null);
    }

    public TreatmentModel save(TreatmentModel treatmentModel) {
        TreatmentModel treatmentModelSaved = repository.save(treatmentModel);
        return treatmentModelSaved;
    }

    public TreatmentModel update(TreatmentModel treatmentModel, Long id) {
        TreatmentModel treatmentModelCurrent = repository.findById(id).orElseThrow();

        treatmentModelCurrent.setPatient(treatmentModel.getPatient());

        return repository.save(treatmentModelCurrent);

    }

    public List<TreatmentModel> delete(long id__treatment) {
        TreatmentModel treatmentToDelete = repository.findById(id__treatment).orElse(null);
        repository.delete(treatmentToDelete);
        return repository.findAll();
    }

}
