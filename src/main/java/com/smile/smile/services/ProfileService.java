package com.smile.smile.services;

import java.util.List;

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

    public ProfileModel findById(Long idProfile) {
        return repository.findById(idProfile).orElse(null);
    }

    public ProfileModel save(ProfileModel profileModel) {
        ProfileModel profileModelSaved = repository.save(profileModel);
        return profileModelSaved;
    }

    public ProfileModel update(ProfileModel profileModel, Long id) {
        ProfileModel profileModelCurrent = repository.findById(id).orElseThrow();

        profileModelCurrent.setName(profileModel.getName());
        profileModelCurrent.setSurname(profileModel.getSurname());
        profileModelCurrent.setPhoneNumber(profileModel.getPhoneNumber());
        profileModelCurrent.setAdress(profileModel.getAdress());
        profileModelCurrent.setCity(profileModel.getCity());

        return repository.save(profileModelCurrent);
    }

    public List<ProfileModel> delete(long idProfile) {

        ProfileModel profileToDelete = repository.findById(idProfile).orElse(null);
        repository.delete(profileToDelete);
        return repository.findAll();

    }
}