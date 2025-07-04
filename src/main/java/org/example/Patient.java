package org.example;

import java.util.Date;
import java.util.Random;

public class Patient {
    private String patientId;
    private String patientName;
    private String patientGender;

    private static final Random random = new Random();

    public Patient(String patientName, String patientGender) {
        this.patientId = generatePatientID();
        this.patientName = patientName;
        this.patientGender = patientGender;
    }

    private String generatePatientID() {
        int randomNumber = random.nextInt(100_000_000);
        return String.format("%08d", randomNumber);
        //return UUID.randomUUID().toString();
    }

    public String getPatientID() {
        return patientId;
    }

    public String getName() {
        return patientName;
    }

    public String getGender() {
        return patientGender;
    }
}
