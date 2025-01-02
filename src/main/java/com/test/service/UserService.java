package com.test.service;

import com.test.entity.Instructor;
import com.test.entity.User;
import com.test.repository.InstructorRepository;
import com.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    public void saveUser(User user) {
        
        User savedUser = userRepository.save(user);
        
        if ("Instructor".equalsIgnoreCase(user.getRole()) && user.getInstructor() != null) {
            Instructor instructor = user.getInstructor();
            instructor.setUser(savedUser); 
            instructorRepository.save(instructor);
        }
    }
}
