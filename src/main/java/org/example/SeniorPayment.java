package org.example;

public class SeniorPayment implements BillingStrategy{
    @Override
    public double calculateDiscountedBill(double amount) {
        System.out.println("Applied 20% discount due to patient's senior identification.");
        return amount*0.8;
    }
}
