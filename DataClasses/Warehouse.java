import java.util.Scanner;

public class Warehouse {

    String address;
    String city;
    String phone;
    String droneCapacity;
    String storageCapacity;

    public Warehouse(String _address, String _city, String _phone, String _droneCapacity, String _storageCapacity) {
        this.address = _address;
        this.city = _city;
        this.phone = _phone;
        this.droneCapacity = _droneCapacity;
        this.storageCapacity = _storageCapacity;
    }

    public void display() {
        System.out.print("Address: " + this.address + " ");
        System.out.print("City: " + this.city + " ");
        System.out.print("Phone: " + this.phone + " ");
        System.out.print("Drone Capacity: " + this.droneCapacity + " ");
        System.out.println("Storage Capacity: " + this.storageCapacity);
    }

    public void edit(Scanner in) {
        String input, data;
        while (true) {
            this.display();
            System.out.print("Enter field to edit: ");
            input = in.nextLine();
            System.out.println("Enter new data: ");
            data = in.nextLine();
            if (input.equalsIgnoreCase("city")) {
                this.city = data;
            } else if (input.equalsIgnoreCase("address")) {
                this.address = data;
            } else if (input.equalsIgnoreCase("phone")) {
                this.phone = data;
            } else if (input.equalsIgnoreCase("Drone Capacity")) {
                this.droneCapacity = data;
            } else if (input.equalsIgnoreCase("Storage Capacity")) {
                this.storageCapacity = data;
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