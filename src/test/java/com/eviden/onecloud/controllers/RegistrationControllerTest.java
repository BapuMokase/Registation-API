package com.eviden.onecloud.controllers;

import static org.mockito.Mockito.when;

import com.eviden.onecloud.models.Registration;
import com.eviden.onecloud.repositories.RegistrationRepository;
import com.eviden.onecloud.services.RegistrationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {RegistrationController.class, RegistrationService.class})
@ExtendWith(SpringExtension.class)
class RegistrationControllerTest {
    @Autowired
    private RegistrationController registrationController;

    @MockBean
    private RegistrationRepository registrationRepository;

    /**
     * Method under test: {@link RegistrationController#getAllRegistration()}
     */
    @Test
    void testGetAllRegistration() throws Exception {
        // Arrange
        when(registrationRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/registration");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(registrationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RegistrationController#insertNewRegistration(Registration)}
     */
    @Test
    void testInsertNewRegistration() throws Exception {
        // Arrange
        Registration registration = new Registration();
        registration.setAvailability("Availability");
        registration.setRegistrationId(1L);
        registration.setRole(new ArrayList<>());
        registration.setSkills(new ArrayList<>());
        registration.setTitle("Dr");
        registration.setTotalYearOfExperience(1);
        when(registrationRepository.save(Mockito.<Registration>any())).thenReturn(registration);

        Registration registration2 = new Registration();
        registration2.setAvailability("Availability");
        registration2.setRegistrationId(1L);
        registration2.setRole(new ArrayList<>());
        registration2.setSkills(new ArrayList<>());
        registration2.setTitle("Dr");
        registration2.setTotalYearOfExperience(1);
        String content = (new ObjectMapper()).writeValueAsString(registration2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(registrationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"registrationId\":1,\"title\":\"Dr\",\"role\":[],\"totalYearOfExperience\":1,\"skills\":[],\"availability\":"
                                        + "\"Availability\"}"));
    }
}

