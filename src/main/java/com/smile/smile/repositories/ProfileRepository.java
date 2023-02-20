package com.smile.smile.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.smile.smile.model.ProfileModel;

public interface ProfileRepository  extends JpaRepository<ProfileModel, Long> {

        public Optional<ProfileModel> findById(Long idProfile);
}
