package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    private Patient testPatient;
    private Patient testPatientNoEmail;

    @BeforeEach
    void setUp() {
        testPatient = new Patient(
                "John Pork",
                "1901-05-15",
                "Male",
                "john.pork@gcash.com");

        testPatientNoEmail = new Patient(
                "Jane Pork",
                "1985-10-12",
                "Female",
                null);
    }

    @Test
    void getPatientID() {
        assertNotNull(testPatient.getPatientID(), "Patient ID should not be null");
        String patientId = testPatient.getPatientID();
        assertNotNull(patientId, "Patient ID should not be null");
        assertEquals(8, patientId.length(), "Patient ID should be 8 characters long");
        assertTrue(patientId.matches("\\d{8}"), "Patient ID should be exactly 8 digits");

        // Test that different patient IDs are generated (though not strictly unique guarantee)
        Patient anotherPatient = new Patient("Marvin Beak", "2000-04-04", "Other", "marvin.beak@gcash.com");
        assertNotEquals(testPatient.getPatientID(), anotherPatient.getPatientID(),
                "Generated patient IDs should be different");
    }

    @Test
    void getName() {
        assertEquals("John Pork", testPatient.getName(), "Patient name should match constructor input");
        assertEquals("Jane Pork", testPatientNoEmail.getName(), "Patient name should match constructor input for no email case");
    }

    @Test
    void getRegistrationDate() {
        assertNotNull(testPatient.getRegistrationDate(), "Registration date should not be null");
        assertTrue(testPatient.getRegistrationDate() instanceof Date, "Registration date should be an instance of Date");
    }

    @Test
    void getBirthday() {
        assertEquals("1901-05-15", testPatient.getBirthday(), "Patient birthday should match input");
        assertEquals("1985-10-12", testPatientNoEmail.getBirthday(), "Patient birthday should match input for null email");
    }

    @Test
    void getGender() {
        assertEquals("Male", testPatient.getGender(), "Patient gender should match input");
        assertEquals("Female", testPatientNoEmail.getGender(), "Patient gender should match input for no email case");
    }

    @Test
    void getEmail() {
        assertEquals("john.pork@gcash.com", testPatient.getEmail(), "Patient email should match input");
        assertNull(testPatientNoEmail.getEmail(), "Patient email should be null when optional email is not provided");
    }
}