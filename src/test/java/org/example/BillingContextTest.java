package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillingContextTest {
    private final double testBillAmount = 900;
    private BillingContext billContext;

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