package com.test.controller;

import com.test.entity.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        
        if ("Instructor".equalsIgnoreCase(user.getRole())) {
            

            if (user.getInstructor() == null ||
                user.getInstructor().getQualification() == null ||
                user.getInstructor().getExperience() == null ||
                user.getInstructor().getExpertise() == null) {

                return new ResponseEntity<>("Missing instructor-specific fields: qualification, experience, or expertise", HttpStatus.BAD_REQUEST);
            }
        }
        userService.saveUser(user);
        return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
    }
}
