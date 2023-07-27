package com.eviden.onecloud.controllers;


// Create Java class RegistrationController with @RestController annotation.
// Import RegistrationService class and auto-wire it.
// Create two methods one with PostMapping /Registration, which accepts Registration as RequestBody and returns boolean.
// Another method with GetMapping /Registration which returns List

import com.eviden.onecloud.models.Registration;
import com.eviden.onecloud.models.RegistrationResponse;
import com.eviden.onecloud.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {

    // Autowired RegistrationService
    @Autowired
    private RegistrationService registrationService;

    // Add a new method insertNewEmployee() method to insert new Registration and
    // return a boolean value true if Registration is inserted successfully else return false
    @PostMapping("/registration")
    public ResponseEntity<RegistrationResponse> insertNewRegistration(@RequestBody Registration registration) {
        registrationService.insertNewRegistration(registration);
        boolean isInserted = registrationService.insertNewRegistration(registration);

        if (isInserted) {
            RegistrationResponse response = new RegistrationResponse(200, "Success");
            return ResponseEntity.ok().body(response);
        } else {
            RegistrationResponse response = new RegistrationResponse(500, "Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // Add a new method getAllEmployees() method to get all Registrations
    @GetMapping("/registration")
    public List<Registration> getAllRegistration() {
        return registrationService.getAllRegistration();
    }
}