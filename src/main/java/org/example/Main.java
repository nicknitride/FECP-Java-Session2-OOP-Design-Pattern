package org.example;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void displayService(){
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("=== Hospital Billing System ===");
        System.out.println("1. Register Patient");
        System.out.println("2. Add Service");
        System.out.println("3. Compute Bill");
        System.out.println("4. Exit");

        int inChoice = 0;
        String inName = null;
        int inID = 0;
        String inService = null;
        String inInsurance = null;


        while(inChoice != 4){
            System.out.print("Enter choice: ");
            inChoice = sc.nextInt();
            sc.nextLine();

            switch (inChoice){
                case 1:
                    System.out.print("Enter Patient Name: ");
                    inName = sc.nextLine();
                    System.out.print("Enter Patient ID: ");
                    inID = sc.nextInt();
                    sc.next();
                    //instantiate patient class
                    //System.out.print("Patient Registered!");
                    break;

                case 2:
                    System.out.println("Available Services: ");
                    System.out.println("XRay (500)");
                    System.out.println("Surgery (12000)");
                    System.out.println("Consultation (700)");
                    System.out.print("Select service to add: ");
                    inService = sc.nextLine();
                    //add to service class
                    //System.out.println("Service added to patient bill.");
                    break;

                case 3:
                    System.out.print("Insurance type (hmo/cash/senior): ");
                    inInsurance = sc.nextLine();
                    System.out.println("Original cost: "); // add base cost calculation
                    System.out.println("Discounted cost: ");// add discount calculation
                    //System.out.println("Bill generated successfully!");

                case 4:
                    System.out.println("Thank you! Get well soon!");

            }
        }
    }
}