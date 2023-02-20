package com.smile.smile.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smile.smile.model.TreatmentModel;

public interface TreatmentRepository  extends JpaRepository <TreatmentModel, Long>{
    public Optional<TreatmentModel> findById(Long idTreatment);

    public List<TreatmentModel> findAll();
    
}
