package ManagerClasses;

import java.util.ArrayList;
import java.util.Scanner;
import DataClasses.*;


public class WarehouseManager {
    public static ArrayList<Warehouse> warehouses = new ArrayList<Warehouse>();


    //Warehouse Methods

    public static void add(Scanner in){
        System.out.print("city: ");
        String city = in.nextLine();
        System.out.print("address: ");
        String address = in.nextLine();
        System.out.print("phone: ");
        String phone = in.nextLine();
        System.out.print("Drone Capacity: ");
        String droneCapacity = in.nextLine();
        System.out.print("Storage Capacity: ");
        String storageCapacity = in.nextLine();
        Warehouse w = new Warehouse(address,city,phone,droneCapacity,storageCapacity);
        warehouses.add(w);
    }

    public static Warehouse select(Scanner in){
        System.out.print("Enter Warehouse address: ");
        String input = in.nextLine();
        for(Warehouse w: warehouses){
            if(w.address.equals(input)){
                return w;
            }
        }
        System.out.print("Error: no warehouse with address " + input);
        return null;
    }

    public static void search(Scanner in){
        System.out.print("Enter attribute to search: ");
        String input = in.nextLine();
        System.out.println("Enter data: ");
        String data = in.nextLine();

        if(input.equalsIgnoreCase("address")){
            for(Warehouse w: warehouses){
                if(w.address.equalsIgnoreCase(data)){
                    w.display();
                }
            }
        } else if(input.equalsIgnoreCase("city")){
            for(Warehouse w: warehouses){
                if(w.city.equalsIgnoreCase(data)){
                    w.display();
                }
            }
        } else if(input.equalsIgnoreCase("phone")){
            for(Warehouse w: warehouses){
                if(w.phone.equalsIgnoreCase(data)){
                    w.display();
                }
            }
        } else if(input.equalsIgnoreCase("Drone Capacity")){
            for(Warehouse w: warehouses){
                if(w.droneCapacity.equalsIgnoreCase(data)){
                    w.display();
                }
            }
        } else if(input.equalsIgnoreCase("Storage Capacity")){
            for(Warehouse w: warehouses){
                if(w.storageCapacity.equalsIgnoreCase(data)){
                    w.display();
                }
            }
        } else {
            System.out.println("Error: invalid attribute");
        }
    }

    public static void displayAll() {
        for(Warehouse w: warehouses){
            w.display();
        }
    }
}