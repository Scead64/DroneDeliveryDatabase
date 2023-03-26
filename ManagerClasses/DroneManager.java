package ManagerClasses;

import java.util.ArrayList;
import java.util.Scanner;
import DataClasses.*;


public class DroneManager {
    public static ArrayList<Drone> drones = new ArrayList<Drone>();

    public static void add(Scanner in){
        System.out.print("Name: ");
        String name = in.nextLine();
        System.out.print("Year: ");
        String year = in.nextLine();
        System.out.print("Max Speed: ");
        String maxSpeed = in.nextLine();
        System.out.print("Weight Capacity: ");
        String weightCapacity = in.nextLine();
        System.out.print("Volume Capacity: ");
        String volumeCapacity = in.nextLine();
        System.out.print("Distance Autonomy: ");
        String distanceAutonomy = in.nextLine();
        System.out.print("Manufacturer: ");
        String manufacturer = in.nextLine();
        System.out.print("Status (True/False): ");
        String status = in.nextLine();
        System.out.print("Warranty Expiration Date: ");
        String warrantyExpirationDate = in.nextLine();
        System.out.print("Model Number: ");
        String modelNumber = in.nextLine();
        System.out.print("Serial Number: ");
        String serialNumber = in.nextLine();
        System.out.print("fleet ID: ");
        String fleetID = in.nextLine();
        Drone d = new Drone(name, weightCapacity, year, maxSpeed, volumeCapacity, distanceAutonomy, manufacturer, status, warrantyExpirationDate, modelNumber, serialNumber, fleetID);
        drones.add(d);
    }

    public static Drone select(Scanner in){
        System.out.print("Enter drone serial number: ");
        String input = in.nextLine();
        for(Drone d: drones){
            if(d.serialNumber.equals(input)){
                return d;
            }
        }
        System.out.print("Error: no drone with serial number " + input);
        return null;
    }

    public static void search(Scanner in){
        System.out.print("Enter attribute to search: ");
        String input = in.nextLine();
        System.out.println("Enter data: ");
        String data = in.nextLine();

        for(Drone d: drones){
            if(input.equalsIgnoreCase("Name") && d.name.equalsIgnoreCase(data)){
                d.display();
            } else if (input.equalsIgnoreCase("Year") && d.year.equalsIgnoreCase(data)) {
                d.display();
            } else if (input.equalsIgnoreCase("Max Speed") && d.maxSpeed.equalsIgnoreCase(data)) {
                d.display();
            } else if (input.equalsIgnoreCase("Weight Capacity") && d.weightCapacity.equalsIgnoreCase(data)) {
                d.display();
            } else if (input.equalsIgnoreCase("Volume Capacity") && d.volumeCapacity.equalsIgnoreCase(data)) {
                d.display();
            } else if (input.equalsIgnoreCase("Distance Autonomy") && d.distanceAutonomy.equalsIgnoreCase(data)) {
                d.display();
            } else if (input.equalsIgnoreCase("Manufacturer") && d.manufacturer.equalsIgnoreCase(data)) {
                d.display();
            } else if (input.equalsIgnoreCase("Status") && d.status.equalsIgnoreCase(data)) {
                d.display();
            } else if (input.equalsIgnoreCase("Model Number") && d.modelNumber.equalsIgnoreCase(data)) {
                d.display();
            } else if (input.equalsIgnoreCase("Warranty Expiration Date") && d.warrantyExpirationDate.equalsIgnoreCase(data)) {
                d.display();
            } else if (input.equalsIgnoreCase("Serial Number") && d.serialNumber.equalsIgnoreCase(data)) {
                d.display();
            } else if (input.equalsIgnoreCase("fleet ID") && d.fleetID.equalsIgnoreCase(data)) {
                d.display();
            } else {
                System.out.println("Error: invalid attribute");
            }
        }
    }

    public static void displayAll() {
        for(Drone d: drones){
            d.display();
        }
    }
}