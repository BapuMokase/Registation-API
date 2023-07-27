package com.eviden.onecloud.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class RegistrationResponseTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RegistrationResponse#RegistrationResponse(int, String)}
     *   <li>{@link RegistrationResponse#toString()}
     *   <li>{@link RegistrationResponse#getStatusCode()}
     *   <li>{@link RegistrationResponse#getStatusMessage()}
     * </ul>
     */
    @Test
    void testConstructor() {
        // Arrange and Act
        RegistrationResponse actualRegistrationResponse = new RegistrationResponse(1, "Status Message");
        String actualToStringResult = actualRegistrationResponse.toString();

        // Assert
        assertEquals(1, actualRegistrationResponse.getStatusCode());
        assertEquals("Status Message", actualRegistrationResponse.getStatusMessage());
        assertEquals("RegistrationResponse(statusCode=1, statusMessage=Status Message)", actualToStringResult);
    }

    /**
     * Method under test: {@link RegistrationResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        // Arrange, Act and Assert
        assertNotEquals(new RegistrationResponse(1, "Status Message"), null);
        assertNotEquals(new RegistrationResponse(1, "Status Message"), "Different type to RegistrationResponse");
    }

}

