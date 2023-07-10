package com.eviden.onecloud.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.eviden.onecloud.models.Registration;

import java.util.ArrayList;
import java.util.List;

import com.eviden.onecloud.repositories.RegistrationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RegistrationServiceTest {
    @Autowired
    private RegistrationService registrationService;
    @MockBean
    private RegistrationRepository registrationRepository;


    /**
     * Method under test: {@link RegistrationService#insertNewRegistration(Registration)}
     */
    @Test
    void testInsertNewRegistration_Successful() {
        // Arrange
        Registration registration = new Registration();
        registration.setAvailability("Availability");
        registration.setRegistrationId(1L);
        registration.setRole(new ArrayList<>());
        registration.setSkills(new ArrayList<>());
        registration.setTitle("Dr");
        registration.setTotalYearOfExperience(1);

        // Act and Assert
        assertTrue(registrationService.insertNewRegistration(registration));
        assertEquals(0, registrationService.getAllRegistration().size());
    }
    /**
     * Method under test: {@link RegistrationService#insertNewRegistration(Registration)}
     */
    @Test
    void testInsertNewRegistration_Failure() {
        Registration registration = new Registration();
        when(registrationRepository.save(registration)).thenThrow(new RuntimeException());

        boolean result = registrationService.insertNewRegistration(registration);

        assertFalse(result);
        verify(registrationRepository, times(1)).save(registration);
    }

    @Test
    void testGetAllRegistration() {
        // Arrange
        ArrayList<Registration> registrationsList = new ArrayList<>();
        when(registrationRepository.findAll()).thenReturn(registrationsList);

        // Act
        List<Registration> actualAllProjects = registrationService.getAllRegistration();

        // Assert
        assertSame(registrationsList, actualAllProjects);
        assertTrue(actualAllProjects.isEmpty());
        verify(registrationRepository).findAll();
    }
}

