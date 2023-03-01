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

<<<<<<< HEAD
    public ProfileModel getOne(Long idProfile) {
        ProfileModel profile = repository.findById(idProfile).orElseThrow();
        return profile;
=======
    public ProfileModel findById(Long idProfile) {
        return repository.findById(idProfile).orElse(null);
>>>>>>> 51d4a7c8e7714d764d02ab6b257b5f6bd94b9ee4
    }

   

    public ProfileModel save(ProfileModel profileModel) {
        ProfileModel profileModelSaved = repository.save(profileModel);
        return profileModelSaved;
    }
<<<<<<< HEAD

    public ProfileModel update(ProfileModel newData, Long id) {
        ProfileModel currentProfile = this.getOne(id);
        return null;
    }
=======
    public List <ProfileModel> delete(long idProfile) {

        ProfileModel profileToDelete = repository.findById(idProfile).orElse(null);
        repository.delete(profileToDelete);
        return repository.findAll();

>>>>>>> 51d4a7c8e7714d764d02ab6b257b5f6bd94b9ee4
}
}