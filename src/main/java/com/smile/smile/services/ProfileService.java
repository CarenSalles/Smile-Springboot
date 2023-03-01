package com.smile.smile.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.smile.smile.model.ProfileModel;
import com.smile.smile.repositories.ProfileRepository;

@Service
public class ProfileService {

    private ProfileRepository repository;

    public ProfileService(ProfileRepository repository) {
        this.repository = repository;
    }

    public List<ProfileModel> getAll() {
        return repository.findAll();
    }

    public ProfileModel getOne(Long idProfile) {
        ProfileModel profile = repository.findById(idProfile).orElseThrow();
        return profile;
    }

    // public PatientModel getOne(String dni) {
    // return repository.findByDni(dni);

    // }

    public ProfileModel save(ProfileModel profileModel) {
        ProfileModel profileModelSaved = repository.save(profileModel);
        return profileModelSaved;
    }

    public ProfileModel update(ProfileModel newData, Long id) {
        ProfileModel currentProfile = this.getOne(id);
        return null;
    }
}
