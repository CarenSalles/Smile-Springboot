package com.smile.smile.controllers;


import java.util.List;
import com.smile.smile.services.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ProfileModel listOne(@PathVariable Long idProfile) {
        return service.getOne(idProfile);

    }
}
