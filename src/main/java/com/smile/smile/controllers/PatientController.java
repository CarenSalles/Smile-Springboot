package com.smile.smile.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.http.HttpStatus;

import com.smile.smile.model.PatientModel;
import com.smile.smile.services.PatientService;

@RestController
@RequestMapping(path = "/api/patients")
public class PatientController {

    private PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<PatientModel> listAll() {
        return service.getAll();
    }

    @GetMapping("/{dni}")
    public PatientModel listOne(@PathVariable String dni) {
        return service.getOne(dni);

    }

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<?> store(@RequestBody PatientModel newPatientModel) {

        try {
            return ResponseEntity.ok(service.save(newPatientModel));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error");
        }
    }

}
