import java.util.Scanner;

public class Equipment {
    
    String type;
    String weight;
    String year;
    String size;
    String description;
    String arrivalDate;
    String modelNumber;
    String serialNumber;
    String inventoryID;    
    String manufacturer;
    String warrantyExp;
    Warehouse warehouse;

    
    public Equipment(String _type, String _weight, String _year, String _size, String _modelNumber, String _serialNumber, String _inventoryID, String _manufacturer, String _arrivalDate, String _warrantyExp, String _description){
        this.type = _type;
        this.weight = _weight;
        this.year = _year;
        this.size = _size;
        this.modelNumber = _modelNumber;
        this.serialNumber = _serialNumber;
        this.inventoryID = _inventoryID;
        this.manufacturer = _manufacturer;
        this.arrivalDate = _arrivalDate;
        this.warrantyExp = _warrantyExp;
        this.description = _description;
    }

    public void display() {
        System.out.print("Type: " + this.type + " ");
        System.out.print("Weight: " + this.weight + " ");
        System.out.print("Year: " + this.year + " ");
        System.out.print("Size: " + this.size + " ");
        System.out.print("Model Number: " + this.modelNumber + " ");
        System.out.print("Serial Number: " + this.serialNumber + " ");
        System.out.print("inventoryID: " + this.inventoryID + " ");
        System.out.print("Manufacturer: " + this.manufacturer + " ");
        System.out.print("Arrival Date: " + this.arrivalDate + " ");
        System.out.print("Warranty Expiration: " + this.warrantyExp + " ");
        System.out.println("Description: " + this.description);
    }

    public void edit(Scanner in) {
        String input, data;
        while (true) {
            this.display();
            System.out.print("Enter field to edit: ");
            input = in.nextLine();
            System.out.println("Enter new data: ");
            data = in.nextLine();
            if (input.equalsIgnoreCase("Type")) {
                this.type = data;
            } else if (input.equalsIgnoreCase("Weight")) {
                this.weight = data;
            } else if (input.equalsIgnoreCase("Year")) {
                this.year = data;
            } else if (input.equalsIgnoreCase("Size")) {
                this.size = data;
            } else if (input.equalsIgnoreCase("Model Number")) {
                this.modelNumber = data;
            } else if (input.equalsIgnoreCase("Serial Number")) {
                this.serialNumber = data;
            } else if (input.equalsIgnoreCase("Inventory ID")) {
                this.inventoryID = data;
            } else if (input.equalsIgnoreCase("Manufacturer")) {
                this.manufacturer = data;
            } else if (input.equalsIgnoreCase("Arrival Date")) {
                this.arrivalDate = data;
            } else if (input.equalsIgnoreCase("Warranty Expiration")) {
                this.warrantyExp = data;
            } else if (input.equalsIgnoreCase("Description")) {
                this.description = data;
            } else {
                System.out.println("Error: invalid attribute");
            }

            System.out.print("Enter 'C' to continue editing ");
            input = in.nextLine();
            if(!input.equalsIgnoreCase("C")){
                break;
            }
        }
    }
}