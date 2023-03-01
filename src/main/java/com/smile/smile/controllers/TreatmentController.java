package com.smile.smile.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<TreatmentModel> findById(@PathVariable Long idTreatment) {
        TreatmentModel treatmentModel = service.findById(idTreatment);
        // return service.findById(idTreatment);
        if (treatmentModel != null) {
            return ResponseEntity.ok(treatmentModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<?> store(@RequestBody TreatmentModel newTreatmentModel) {

        try {
            return ResponseEntity.ok(service.save(newTreatmentModel));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error");
        }
    }
}
