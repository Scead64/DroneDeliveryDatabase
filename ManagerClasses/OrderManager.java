package ManagerClasses;

import java.util.ArrayList;
import java.util.Scanner;
import DataClasses.*;


public class OrderManager {
    public static ArrayList<Order> orders = new ArrayList<Order>();

    public static void add(Scanner in){
        System.out.print("Description: ");
        String description = in.nextLine();
        System.out.print("Estimated DOA: ");
        String estimatedDOA = in.nextLine();
        System.out.print("Element Type: ");
        String elementType = in.nextLine();
        System.out.print("Order Number: ");
        String orderNumber = in.nextLine();
        System.out.print("value");
        String value = in.nextLine();
        System.out.print("numberOrdered");
        String numberOrdered = in.nextLine();
        Order o = new Order(description, estimatedDOA, elementType, orderNumber, value, numberOrdered);
        orders.add(o);
    }

    public static Order select(Scanner in){
        System.out.print("Enter order number: ");
        String input = in.nextLine();
        for(Order o: orders){
            if(o.orderNumber.equals(input)){
                return o;
            }
        }
        System.out.print("Error: no Order with number " + input);
        return null;
    }

    public static void search(Scanner in){
        System.out.print("Enter attribute to search: ");
        String input = in.nextLine();
        System.out.println("Enter data: ");
        String data = in.nextLine();

        for(Order o: orders){
            if(input.equalsIgnoreCase("Description") && o.description.equalsIgnoreCase(data)){
                o.display();
            } else if (input.equalsIgnoreCase("Estimated DOA") && o.estimatedDOA.equalsIgnoreCase(data)) {
                o.display();
            } else if (input.equalsIgnoreCase("Element Type") && o.elementType.equalsIgnoreCase(data)) {
                o.display();
            } else if (input.equalsIgnoreCase("Order Number") && o.orderNumber.equalsIgnoreCase(data)) {
                o.display();
            } else if (input.equalsIgnoreCase("Value") && o.value.equalsIgnoreCase(data)) {
                o.display();
            } else if (input.equalsIgnoreCase("Number Ordered") && o.numberOrdered.equalsIgnoreCase(data)) {
                o.display();
            } else {
                System.out.println("Error: invalid attribute");
            }
        }
    }

    public static void displayAll() {
        for(Order o: orders){
            o.display();
        }
    }
}