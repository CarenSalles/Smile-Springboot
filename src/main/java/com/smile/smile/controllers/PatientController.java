package com.smile.smile.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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
    public PatientModel listOne(@PathVariable String dniPatient) {
        return service.getOne(dniPatient);

    }

}
