package com.smile.smile.controllers;

import java.util.List;
import com.smile.smile.controllers.ProfileService;
import com.smile.smile.model.ProfileModel;

public interface ProfileService {

    List<ProfileModel> getAll();

    ProfileModel getOne(Long idProfile);

}
