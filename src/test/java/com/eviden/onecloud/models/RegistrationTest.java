package com.eviden.onecloud.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class RegistrationTest {

    /**
     * Method under test: {@link Registration#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        // Arrange
        Registration registration = new Registration();
        registration.setAvailability("Availability");
        registration.setRegistrationId(1L);
        registration.setRole(new ArrayList<>());
        registration.setSkills(new ArrayList<>());
        registration.setTitle("Dr");
        registration.setTotalYearOfExperience(1);

        Registration registration2 = new Registration();
        registration2.setAvailability("Availability");
        registration2.setRegistrationId(1L);
        registration2.setRole(new ArrayList<>());
        registration2.setSkills(new ArrayList<>());
        registration2.setTitle("Dr");
        registration2.setTotalYearOfExperience(1);

        // Act and Assert
        assertTrue(registration.canEqual(registration2));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Registration#Registration()}
     *   <li>{@link Registration#setAvailability(String)}
     *   <li>{@link Registration#setRegistrationId(Long)}
     *   <li>{@link Registration#setRole(List)}
     *   <li>{@link Registration#setSkills(List)}
     *   <li>{@link Registration#setTitle(String)}
     *   <li>{@link Registration#setTotalYearOfExperience(Integer)}
     *   <li>{@link Registration#toString()}
     *   <li>{@link Registration#getAvailability()}
     *   <li>{@link Registration#getRegistrationId()}
     *   <li>{@link Registration#getRole()}
     *   <li>{@link Registration#getSkills()}
     *   <li>{@link Registration#getTitle()}
     *   <li>{@link Registration#getTotalYearOfExperience()}
     * </ul>
     */
    @Test
    void testConstructor() {
        // Arrange and Act
        Registration actualRegistration = new Registration();
        actualRegistration.setAvailability("Availability");
        actualRegistration.setRegistrationId(1L);
        ArrayList<String> role = new ArrayList<>();
        actualRegistration.setRole(role);
        ArrayList<String> skills = new ArrayList<>();
        actualRegistration.setSkills(skills);
        actualRegistration.setTitle("Dr");
        actualRegistration.setTotalYearOfExperience(1);
        String actualToStringResult = actualRegistration.toString();

        // Assert that nothing has changed
        assertEquals("Availability", actualRegistration.getAvailability());
        assertEquals(1L, actualRegistration.getRegistrationId().longValue());
        List<String> role2 = actualRegistration.getRole();
        assertSame(role, role2);
        List<String> skills2 = actualRegistration.getSkills();
        assertEquals(skills2, role2);
        assertSame(skills, skills2);
        assertEquals(role, skills2);
        assertEquals("Dr", actualRegistration.getTitle());
        assertEquals(1, actualRegistration.getTotalYearOfExperience().intValue());
        assertEquals("Registration(registrationId=1, title=Dr, role=[], totalYearOfExperience=1, skills=[], availability"
                + "=Availability)", actualToStringResult);
    }

    /**
     * Method under test: {@link Registration#equals(Object)}
     */
    @Test
    void testEquals() {
        // Arrange
        Registration registration = new Registration();
        registration.setAvailability("Availability");
        registration.setRegistrationId(1L);
        registration.setRole(new ArrayList<>());
        registration.setSkills(new ArrayList<>());
        registration.setTitle("Dr");
        registration.setTotalYearOfExperience(1);

        // Act and Assert
        assertNotEquals(registration, null);
    }
}

