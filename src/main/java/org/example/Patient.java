package org.example;

import java.util.Date;
import java.util.Random;

public class Patient {
    private String patientId;
    private String patientName;
    private Date registrationDate;
    private String dateOfBirth;
    private String patientGender;
    private String patientEmail;

    private static final Random random = new Random();

    public Patient(String patientName, String dateOfBirth, String patientGender, String patientEmail){
        this.patientId = generatePatientID();
        this.patientName = patientName;
        this.registrationDate = new Date();
        this.dateOfBirth = dateOfBirth;
        this.patientGender = patientGender;
        this.patientEmail = patientEmail;
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public String getBirthday() {
        return dateOfBirth;
    }

    public String getGender() {
        return patientGender;
    }

    public String getEmail() {
        return patientEmail;
    }
}
