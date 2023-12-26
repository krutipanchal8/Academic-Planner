package com.academicplannerbackend.service;

import com.academicplannerbackend.model.JwtResponse;
import com.academicplannerbackend.model.User;

public interface UserService {
    void register(User user);
    JwtResponse loginProcess(User user);

    void updateProfileStatus(String name);
}
