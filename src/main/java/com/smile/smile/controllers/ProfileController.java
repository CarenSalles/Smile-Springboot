package com.smile.smile.controllers;

import java.util.List;
import com.smile.smile.services.ProfileService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.smile.smile.model.ProfileModel;

// import com.smile.smile.controllers.ProfileService;
@RestController
@RequestMapping(path = "/api/profiles")
public class ProfileController {

    private ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<ProfileModel> listAll() {
        return service.getAll();
    }

    @GetMapping("/{idProfile}")
    public ResponseEntity<ProfileModel> findById(@PathVariable Long idProfile) {
        ProfileModel profile = service.findById(idProfile);
        if (profile != null) {
            return ResponseEntity.ok(profile);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<?> store(@RequestBody ProfileModel newProfileModel) {

        try {
            return ResponseEntity.ok(service.save(newProfileModel));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error");
        }
    }
    @DeleteMapping("/{idpatient}")
    public List<ProfileModel> delete(@PathVariable long idpatient) {
        return service.delete(idpatient);}

}
