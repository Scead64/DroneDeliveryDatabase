package DataClasses;
import java.util.Scanner;

public class Drone {
    
    public String name;
    public String weightCapacity;
    public String year;
    public String maxSpeed;
    public String volumeCapacity;
    public String distanceAutonomy;
    public String manufacturer;
    public String status;
    public String warrantyExpirationDate;
    public String modelNumber;
    public String serialNumber;
    public String fleetID;
    
    public Drone(String _name, String _weightCapacity, String _year, String _maxSpeed, String _volumeCapacity, String _distanceAutonomy, String _manufacturer, String _status, String _warrantyExpirationDate, String _modelNumber, String _serialNumber, String _fleetID){
        this.name = _name;
        this.weightCapacity = _weightCapacity;
        this.year = _year;
        this.maxSpeed = _maxSpeed;
        this.volumeCapacity = _volumeCapacity;
        this.distanceAutonomy = _distanceAutonomy;
        this.manufacturer = _manufacturer;
        this.status = _status;
        this.warrantyExpirationDate = _warrantyExpirationDate;
        this.modelNumber = _modelNumber;
        this.serialNumber = _serialNumber;
        this.fleetID = _fleetID;
    }

    public void display() {
        System.out.println("Name: " + this.name);
        System.out.println("Weight Capacity: " + this.weightCapacity);
        System.out.println("Year: " + this.year);
        System.out.println("Max Speed: " + this.maxSpeed);
        System.out.println("Volume Capacity: " + this.volumeCapacity);
        System.out.println("Distance Autonomy: " + this.distanceAutonomy);
        System.out.println("Manufacturer: " + this.manufacturer);
        System.out.println("Status: " + this.status);
        System.out.println("Warranty Expiration Date: " + this.warrantyExpirationDate);
        System.out.println("Model Number: " + this.modelNumber);
        System.out.println("Serial Number: " + this.serialNumber);
        System.out.println("Fleet ID: " + this.fleetID);
        System.out.println();
    }

    public void edit(Scanner in) {
        while (true) {
            System.out.print("Enter field to edit: ");
            String input = in.nextLine();
            System.out.print("Enter new data: ");
            String data = in.nextLine();

            switch (input.toLowerCase()) {
                case "name":
                    this.name = data;
                    break;
                case "weight capacity":
                    this.weightCapacity = data;
                    break;
                case "year":
                    this.year = data;
                    break;
                case "max speed":
                    this.maxSpeed = data;
                    break;
                case "volume capacity":
                    this.volumeCapacity = data;
                    break;
                case "distance autonomy":
                    this.distanceAutonomy = data;
                    break;
                case "manufacturer":
                    this.manufacturer = data;
                    break;
                case "status":
                    this.status = data;
                    break;
                case "warranty expiration date":
                    this.warrantyExpirationDate = data;
                    break;
                case "model number":
                    this.modelNumber = data;
                    break;
                case "serial number":
                    this.serialNumber = data;
                    break;
                case "fleet id":
                    this.fleetID = data;
                    break;
                default:
                    System.out.println("Error: invalid attribute");
                    break;
            }

            System.out.print("Enter 'C' to continue editing ");
            input = in.nextLine();
            if (!input.equalsIgnoreCase("C")) {
                break;
            }
        }
    }
}