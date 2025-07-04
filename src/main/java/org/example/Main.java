package org.example;
import java.util.*;

public class Main {

    public static double getTotalCost(List<Service> serviceArrayList){
        double finalCost = 0;
        for (int i = 0; i <= (serviceArrayList.size()-1) ; i++) {
            finalCost += serviceArrayList.get(i).getCost();
        }
        return finalCost;
    }
    static void displayMenu(){
        System.out.println("\n=== Hospital Billing System ===");
        System.out.println("1. Register Patient");
        System.out.println("2. Add Service");
        System.out.println("3. Compute Bill");
        System.out.println("4. Exit");
    }

    static void clearAllDetails(Patient patient, List<Service> serviceList){
        serviceList.clear();
        patient = null;
        System.out.println("User and bill data cleared. Please register a new patient");
    }

    static void getServicesAvailed(List<Service> serviceArrayList){
        System.out.println("----------- Service Availed Summary -------------");
        for (int i = 0; i <= (serviceArrayList.size()-1) ; i++) {
            System.out.println("Service "+(i+1)+": "+serviceArrayList.get(i).getName());
            System.out.println("Cost: "+serviceArrayList.get(i).getCost());
        }
        System.out.println("-------------------------------------------");
    }
    public static void main(String[] args) {
        Patient newPatient = null;
        Scanner sc =  new Scanner(System.in);
        List<Service> availedServices = new ArrayList<>();
        ServiceFactory createService = new ServiceFactory();
        BillingStrategy billingStrategy;
        String patientName = "";


        String inChoice = "";
        String inService = null;



        while(!inChoice.equals("4")){
            displayMenu();
            System.out.print("Enter choice: ");
            inChoice = sc.nextLine();

            switch (inChoice){
                case "1":
                    if(newPatient == null){
                        System.out.print("Enter Patient Name: ");
                        patientName = sc.nextLine();
                        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
                        String dob = sc.nextLine(); //dob = date of birth
                        System.out.print("Sex: ");
                        String gender = sc.nextLine();
                        System.out.print("Enter email (optional): ");
                        String email = sc.nextLine();
                        if (email.isEmpty()){
                            email = null;
                        }
                        newPatient = new Patient(patientName, dob, gender, email);
                        System.out.println("Patient Registered!");
                        System.out.println("Patient ID: " + newPatient.getPatientID());
                        break;
                    }else{
                        System.out.println("Error bill already tied to patient ID no: "+newPatient.getPatientID());
                        System.out.println("Would you like to clear this billing and start over? (y/n): ");
                        String innerChoice = sc.nextLine().toLowerCase();
                        if (innerChoice.equals("y")){
                            clearAllDetails(newPatient,availedServices);
                        }
                        break;
                    }
                case "2":
                    if(newPatient==null){
                        System.out.println("Error, no patient tied to bill.");
                        break;
                    }
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
                    getServicesAvailed(availedServices);
                    break;
                case "3":
                    if(newPatient==null){
                        System.out.println("Error, no patient tied to bill.");
                        break;
                    } else if (availedServices.isEmpty()) {
                        System.out.println("Error, no services availed.");
                        break;
                    }
                    System.out.println("----------Insurance/Discount Types----------");
                    System.out.println("1. HMO");
                    System.out.println("2. Cash/None");
                    System.out.println("3. Senior");
                    System.out.print("Enter discount type (1-3): ");
                    String insuranceType = sc.nextLine();
                    double discountedBill = 0;
                    if (insuranceType.equals("1")){
                        System.out.println("Selected HMO.");
                        billingStrategy = new HmoPayment();
                        discountedBill = billingStrategy.calculateDiscountedBill(getTotalCost(availedServices));
                    } else if (insuranceType.equals("2")) {
                        System.out.println("Selected Cash.");
                        billingStrategy = new BasePayment();
                        discountedBill = billingStrategy.calculateDiscountedBill(getTotalCost(availedServices));
                    } else if (insuranceType.equals("3")) {
                        System.out.println("Selected Senior Discount.");
                        billingStrategy = new SeniorPayment();
                        discountedBill = billingStrategy.calculateDiscountedBill(getTotalCost(availedServices));
                    }else{
                        System.out.println("Please input a number between 1-3");
                    }
                    System.out.println("\n\n-------------Final Bill for ("+(patientName)+")-------------");
                    System.out.println("Patent ID: "+newPatient.getPatientID());
                    getServicesAvailed(availedServices);
                    System.out.println("Original cost: "+getTotalCost(availedServices)); // add base cost calculation
                    System.out.println("Discounted cost: "+discountedBill);// add discount calculation
                    System.out.println("--------------------------");
                    System.out.println("BILL PRINTED. Thank you!");
                    break;
                case "4":
                    System.out.println("Thank you! Get well soon!");
                    break;
                default:
                    System.out.println("Invalid input. Enter a number between (1-4)");
            }
        }
    }
}