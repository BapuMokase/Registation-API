package com.eviden.onecloud.services;

// Create Java class RegistrationService with @Service annotation.
// Import Registration class and auto-wire RegistrationRepository

import com.eviden.onecloud.models.Registration;
import com.eviden.onecloud.repositories.RegistrationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    // Add a new method insertNewEmployee() method to insert new Registration and
    // return a boolean value true if Registration is inserted successfully else return false
    public boolean insertNewRegistration(Registration registration) {
        try {
            registrationRepository.save(registration);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Add a new method getAllRegistration() method to get all Registrations
    public List<Registration> getAllRegistration() {
        return registrationRepository.findAll();
    }
}
