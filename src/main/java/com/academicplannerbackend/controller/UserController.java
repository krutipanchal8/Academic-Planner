package com.academicplannerbackend.controller;

import com.academicplannerbackend.exception.UnAuthorizedUserException;
import com.academicplannerbackend.exception.UserNotFoundException;
import com.academicplannerbackend.exception.VerificationException;
import com.academicplannerbackend.model.JwtResponse;
import com.academicplannerbackend.model.User;
import com.academicplannerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        userService.register(user);
        return ResponseEntity.ok("User registered successfully.");
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            JwtResponse jwtResponse = userService.loginProcess(user);
            return ResponseEntity.ok(jwtResponse);
        } catch (UnAuthorizedUserException | VerificationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PutMapping("/user/meta/status")
    public ResponseEntity<?> updateProfileStatus(Principal principal) {
        try {
            userService.updateProfileStatus(principal.getName());
            return ResponseEntity.ok("Profile status updated to SET");
        } catch (Exception e) {
            String errorMessage = "Failed to update profile status: " + e.getMessage();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorMessage);
        }
    }
}
