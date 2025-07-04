package org.example;

public class HmoPayment implements BillingStrategy{
    @Override
    public double calculateDiscountedBill(double amount){
        System.out.println("Deducted misc. fee and 15% of cost.");
        return (amount*0.75)-100; //Minus the 100 peso misc. fee and 15%
    }
}
