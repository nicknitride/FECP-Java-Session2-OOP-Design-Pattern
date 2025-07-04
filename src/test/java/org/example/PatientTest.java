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
                "Male");
    }

    @Test
    void getPatientID() {
        assertNotNull(testPatient.getPatientID());
        String patientId = testPatient.getPatientID();
        assertNotNull(patientId);
        assertEquals(8, patientId.length());
        assertTrue(patientId.matches("\\d{8}"));

        // Test that different patient IDs are generated (though not strictly unique guarantee)
        Patient anotherPatient = new Patient("Marvin Beak", "Female");
        assertNotEquals(testPatient.getPatientID(), anotherPatient.getPatientID());
    }

    @Test
    void getName() {
        assertEquals("John Pork", testPatient.getName());
        assertEquals("Jane Pork", testPatientNoEmail.getName());
    }

    @Test
    void getGender() {
        assertEquals("Male", testPatient.getGender(), "Patient gender should match input");
        assertEquals("Female", testPatientNoEmail.getGender(), "Patient gender should match input for no email case");
    }
}