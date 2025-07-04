package org.example;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        List<Patient> registeredPatients = new ArrayList<>();
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
                    String patientName = sc.nextLine();
                    //System.out.print("Enter Patient ID: ");
                    //inID = sc.nextInt();
                    //sc.next();
                    //instantiate patient class
                    //System.out.print("Patient Registered!");
                    System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
                    String dob = sc.nextLine(); //dob = date of birth
                    System.out.print("Sex: ");
                    String gender = sc.nextLine();
                    System.out.print("Enter email (optional): ");
                    String email = sc.nextLine();
                    if (email.isEmpty()){
                        email = null;
                    }

                    Patient newPatient = new Patient(patientName, dob, gender, email);
                    registeredPatients.add(newPatient);

                    System.out.println("Patient Registered!");
                    System.out.println("Patient ID: " + newPatient.getPatientID());
                    break;

                case 2:
                    System.out.println("Available Services: ");
                    // display services offered
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