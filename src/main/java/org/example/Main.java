package org.example;
import java.util.*;

public class Main {

    public static double getTotalCost(ArrayList<Service> serviceArrayList){
        double finalCost = 0;
        for (int i = 0; i <= (serviceArrayList.size()-1) ; i++) {
            finalCost += serviceArrayList.get(i).getCost();
        }
        return finalCost;
    }

    public static void displayService(){
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        List<Patient> registeredPatients = new ArrayList<>();
        List<Service> availedServices = new ArrayList<>();
        ServiceFactory createService = new ServiceFactory();

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
                    System.out.println("XRay (500)");
                    System.out.println("Surgery (12000)");
                    System.out.println("Consultation (700)");
                    System.out.print("Select service to add: ");
                    inService = sc.nextLine();
                    Service newService = createService.getService(inService);
                    if (newService == null){
                        System.out.println("Invalid service type, please try again");
                        break;
                    }
                    availedServices.add(newService);
                    System.out.println("Service added to patient bill: " + availedServices.getLast().getName() + "(" + availedServices.getLast().getCost() + ")");
                    break;
                case 3:
                    System.out.print("Insurance type (hmo/cash/senior): ");
                    String insuranceType = sc.nextLine();


                    System.out.println("Original cost: "+getTotalCost()); // add base cost calculation
                    System.out.println("Discounted cost: ");// add discount calculation
                    //System.out.println("Bill generated successfully!");
                case 4:
                    System.out.println("Thank you! Get well soon!");
            }
        }
    }
}