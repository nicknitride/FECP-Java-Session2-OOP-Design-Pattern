package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UnifiedTest {
    private final double testBillAmount = 900;
    private BillingContext billContext;
    ServiceFactory sv = new ServiceFactory();
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
        assertEquals("John Pork", testPatient.getName());;
    }

    @Test
    void getGender() {
        assertEquals("Male", testPatient.getGender());
    }

    @Test
    void getValidXrayServiceCost() {
        XRay xray = new XRay();
        assertEquals(xray.getCost(), sv.getService("Xray").getCost());
    }

    @Test
    void getValidSurgeryServiceCost() {
        Surgery surgery = new Surgery();
        assertEquals(surgery.getCost(), sv.getService("Surgery").getCost());
    }

    @Test
    void getValidConsultServiceCost() {
        Consultation consult = new Consultation();
        assertEquals(consult.getCost(), sv.getService("Consultation").getCost());
    }

    @Test
    void getInvalidService(){
        assertNull(sv.getService("Botox"));
    }

    @Test
    void testHmoPayment(){
        billContext = new BillingContext();
        billContext.setBillStrategy(new HmoPayment());
        double actual = billContext.calculateFinalBill(testBillAmount);
        Assertions.assertEquals(((testBillAmount*0.75)-100),actual);
    }
    @Test
    void testBasePayment(){
        billContext = new BillingContext();
        billContext.setBillStrategy(new BasePayment());
        double actual = billContext.calculateFinalBill(testBillAmount);
        Assertions.assertEquals((testBillAmount),actual);
    }
    @Test
    void testSeniorPayment(){
        billContext = new BillingContext();
        billContext.setBillStrategy(new SeniorPayment());
        double actual = billContext.calculateFinalBill(testBillAmount);
        Assertions.assertEquals((testBillAmount*0.8),actual);
    }
}