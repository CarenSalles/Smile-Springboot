package com.smile.smile.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.smile.smile.model.TreatmentModel;
import com.smile.smile.services.TreatmentService;

@RestController
@RequestMapping(path = "/api/treatments")
public class TreatmentController {

    private TreatmentService service;

    public TreatmentController(TreatmentService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<TreatmentModel> listAll() {
        return service.getAll();
    }

    @GetMapping("/{idTreatment}")
    public TreatmentModel listOne(@PathVariable Long idTreatment) {
        return service.getOne(idTreatment);
    }

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<?> store(@RequestBody TreatmentModel newTreatmentModel) {

        try {
            return ResponseEntity.ok(service.save(newTreatmentModel));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error");
        }
    @PutMapping("/{idTreatment}") // Abreviatura de RequestMapping para dicir que es un metodo put.
    public ResponseEntity<?> update(@RequestBody TreatmentModel newTreatmentModel, @PathVariable Long idTreatment) {
        Optional<TreatmentModel> treatmentModel = TreatmentService.findById(idTreatment);
        if (!TreatmentModel.isPresent() )
            return ResponseEntity.notFound().build();
        }    
        newTreatmentModel.get().setPatient(newTreatmentModel.getPatient());
        return ResponseEntity.status(HttpStatus.CREATED).body(TreatmentService.save(newTreatmentModel.get()));

    }
}
