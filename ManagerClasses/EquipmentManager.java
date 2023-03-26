package ManagerClasses;

import java.util.ArrayList;
import java.util.Scanner;
import DataClasses.Equipment;


public class EquipmentManager {
    public static ArrayList<Equipment> equipment = new ArrayList<Equipment>();

    public static void add(Scanner in){
        System.out.print("Type: ");
        String type = in.nextLine();
        System.out.print("Weight");
        String weight = in.nextLine();
        System.out.print("Year");
        String year = in.nextLine();
        System.out.print("Size");
        String size = in.nextLine();
        System.out.print("Model Number");
        String modelNumber = in.nextLine();
        System.out.print("Serial Number");
        String serialNumber = in.nextLine();
        System.out.print("Inventory ID");
        String inventoryID = in.nextLine();
        System.out.print("Manufacturer");
        String manufacturer = in.nextLine();
        System.out.print("Arrival Date");
        String arrivalDate = in.nextLine();
        System.out.print("Warranty Expiration");
        String warrantyExp = in.nextLine();
        System.out.print("Description");
        String description = in.nextLine();
        Equipment e = new Equipment(type, weight, year, size, modelNumber, serialNumber, inventoryID, manufacturer, arrivalDate, warrantyExp, description);
        equipment.add(e);
    }

    public static Equipment select(Scanner in){
        System.out.print("Enter Equipment address: ");
        String input = in.nextLine();
        for(Equipment w: equipment){
            if(w.serialNumber.equals(input)){
                return w;
            }
        }
        System.out.print("Error: no Equipment with serial number " + input);
        return null;
    }

    public static void search(Scanner in){
        System.out.print("Enter attribute to search: ");
        String input = in.nextLine();
        System.out.println("Enter data: ");
        String data = in.nextLine();

        for(Equipment e: equipment){
            if(input.equalsIgnoreCase("Type") && e.type.equalsIgnoreCase(data)){
                e.display();
            } else if (input.equalsIgnoreCase("Weight") && e.weight.equalsIgnoreCase(data)) {
                e.display();
            } else if (input.equalsIgnoreCase("Year") && e.year.equalsIgnoreCase(data)) {
                e.display();
            } else if (input.equalsIgnoreCase("Size") && e.size.equalsIgnoreCase(data)) {
                e.display();
            } else if (input.equalsIgnoreCase("Model Number") && e.modelNumber.equalsIgnoreCase(data)) {
                e.display();
            } else if (input.equalsIgnoreCase("Serial Number") && e.serialNumber.equalsIgnoreCase(data)) {
                e.display();
            } else if (input.equalsIgnoreCase("Inventory ID") && e.inventoryID.equalsIgnoreCase(data)) {
                e.display();
            } else if (input.equalsIgnoreCase("Manufacturer") && e.manufacturer.equalsIgnoreCase(data)) {
                e.display();
            } else if (input.equalsIgnoreCase("Arrival Date") && e.arrivalDate.equalsIgnoreCase(data)) {
                e.display();
            } else if (input.equalsIgnoreCase("Warranty Expiration") && e.warrantyExp.equalsIgnoreCase(data)) {
                e.display();
            } else if (input.equalsIgnoreCase("Description") && e.description.equalsIgnoreCase(data)) {
                e.display();
            } else {
                System.out.println("Error: invalid attribute");
            }
        }
    }

    public static void displayAll() {
        for(Equipment e: equipment){
            e.display();
        }
    }
}