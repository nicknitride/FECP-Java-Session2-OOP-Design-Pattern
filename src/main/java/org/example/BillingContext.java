package org.example;

import java.util.InputMismatchException;

public class BillingContext {//For strategy classes, the context class allows us to set the strategy to use
    // and to modify behavior from main
    private BillingStrategy billStrategy; //Private so only this class can set its own strategy

    public void setBillStrategy(BillingStrategy strategy){//This method enables the context to switch
        this.billStrategy = strategy;
    }

    public double calculateFinalBill(double patientBill){//Return the appropriate value by switching implementation
        //Controlled by each class that implements BillingStrategy
        if (billStrategy==null){
            throw new InputMismatchException("Bill strategy not properly declared.");
        }
        return billStrategy.calculateDiscountedBill(patientBill);
    }
}
