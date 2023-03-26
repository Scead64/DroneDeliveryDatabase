package DataClasses;

import java.util.Scanner;

public class Order {
    
    public String description;
    public String estimatedDOA;
    public String elementType;
    public String orderNumber;
    public String value;
    public String numberOrdered;
    
    public Order(String _description, String _estimatedDOA, String _elementType, String _orderNumber, String _value, String _numberOrdered){
        this.description = _description;
        this.estimatedDOA = _estimatedDOA;
        this.elementType = _elementType;
        this.orderNumber = _orderNumber;
        this.value = _value;
        this.numberOrdered = _numberOrdered;
    }

    public void display(){
        System.out.println("Description: " + this.description);
        System.out.println("Estimated DOA: " + this.estimatedDOA);
        System.out.println("Element Type: " + this.elementType);
        System.out.println("Order Number: " + this.orderNumber);
        System.out.println("Value: " + this.value);
        System.out.println("Number Ordered: " + this.numberOrdered);
        System.out.println();
    }
    
    public void edit(Scanner in){
        String input, data;
        while(true){
            System.out.print("Enter field to edit: ");
            input = in.nextLine();
            System.out.print("Enter new data: ");
            data = in.nextLine();
    
            switch(input.toLowerCase()){
                case "description":
                    this.description = data;
                    break;
                case "estimated doa":
                    this.estimatedDOA = data;
                    break;
                case "element type":
                    this.elementType = data;
                    break;
                case "order number":
                    this.orderNumber = data;
                    break;
                case "value":
                    this.value = data;
                    break;
                case "number ordered":
                    this.numberOrdered = data;
                    break;
                default:
                    System.out.println("Error: invalid attribute");
                    break;
            }
    
            System.out.print("Enter 'C' to continue editing ");
            input = in.nextLine();
            if(!input.equalsIgnoreCase("C")){
                break;
            }
        }
    }
}