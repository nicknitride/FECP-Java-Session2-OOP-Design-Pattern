package org.example;

public class BasePayment implements BillingStrategy{
    @Override
    public double calculateDiscountedBill(double amount){
        System.out.println("No discount applied.");
        return amount;
    }
}
