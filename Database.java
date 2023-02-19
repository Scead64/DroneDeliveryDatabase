import java.util.Scanner;
import java.util.ArrayList;


public class Database{

    //Employee methods

    public static void addEmployee(Scanner in){
        System.out.print("fname: ");
        String fname = in.nextLine();
        System.out.print("lname: ");
        String lname = in.nextLine();
        System.out.print("address: ");
        String address = in.nextLine();
        System.out.print("email: ");
        String email = in.nextLine();
        System.out.print("password: ");
        String password = in.nextLine();
        System.out.print("phone: ");
        String phone = in.nextLine();
        System.out.print("YOE: ");
        String YOE = in.nextLine();
        System.out.print("salary: ");
        String salary = in.nextLine();
        Employee e = new Employee(id_num, fname,lname,address,email,password,phone,YOE,salary);
        employees.add(e);
        id_num++;
    }

    public static void editEmployee(Scanner in){
        Employee e = searchEmployees(in);
        String input;
        if(e != null){
            while(true){
                displayEmployee(e);
                System.out.print("Enter field to edit: ");
                input = in.nextLine();
                if(input.equalsIgnoreCase("fname")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    e.fname = input;
                } else if(input.equalsIgnoreCase("lname")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    e.lname = input;
                } else if(input.equalsIgnoreCase("address")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    e.address = input;
                } else if(input.equalsIgnoreCase("email")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    e.email = input;
                } else if(input.equalsIgnoreCase("password")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    e.password = input;
                } else if(input.equalsIgnoreCase("phone")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    e.phone = input;
                } else if(input.equalsIgnoreCase("YOE")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    e.YOE = input;
                } else if(input.equalsIgnoreCase("salary")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    e.salary = input;
                } else {
                    System.out.println("Error: invalid attribute");
                }

                System.out.print("Continue? (Y/N) ");
                input = in.nextLine();
                if(input.equalsIgnoreCase("Y")){
                    break;
                }
            }
        }
    }

    public static void deleteEmployee(Scanner in){
        Employee e = searchEmployees(in);
        if(e != null){
            employees.remove(e);
        }
    }

    public static Employee searchEmployees(Scanner in){
        System.out.print("Enter employee userID: ");
        String input = in.nextLine();
        int id;
        try{
            id = Integer.parseInt(input);
            for(Employee e: employees){
                if(e.userID == id){
                    return e;
                }
            }
            System.out.print("Error: no employee with id " + id);
        } catch(NumberFormatException ex) {
            System.out.print("Error: invalid id " + input);
        }
        return null;
    }

    public static void displayEmployee(Employee e){
        System.out.print(e.userID + " ");
        System.out.print(e.fname + " ");
        System.out.print(e.lname + " ");
        System.out.print(e.address + " ");
        System.out.print(e.email + " ");
        System.out.print(e.password + " ");
        System.out.print(e.phone + " ");
        System.out.print(e.YOE + " ");
        System.out.println(e.salary);
    }
    
    //Member Methods

    public static void addMember(Scanner in){
        System.out.print("fname: ");
        String fname = in.nextLine();
        System.out.print("lname: ");
        String lname = in.nextLine();
        System.out.print("address: ");
        String address = in.nextLine();
        System.out.print("email: ");
        String email = in.nextLine();
        System.out.print("password: ");
        String password = in.nextLine();
        System.out.print("phone: ");
        String phone = in.nextLine();
        System.out.print("Start Date: ");
        String startDate = in.nextLine();
        Member m = new Member(id_num, fname,lname,address,email,password,phone,startDate);
        members.add(m);
        id_num++;
    }

    public static void editMember(Scanner in){
        Member m = searchMembers(in);
        String input;
        if(m != null){
            while(true){
                displayMember(m);
                System.out.print("Enter field to edit: ");
                input = in.nextLine();
                if(input.equalsIgnoreCase("fname")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    m.fname = input;
                } else if(input.equalsIgnoreCase("lname")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    m.lname = input;
                } else if(input.equalsIgnoreCase("address")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    m.address = input;
                } else if(input.equalsIgnoreCase("email")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    m.email = input;
                } else if(input.equalsIgnoreCase("password")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    m.password = input;
                } else if(input.equalsIgnoreCase("phone")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    m.phone = input;
                } else if(input.equalsIgnoreCase("start date")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    m.startDate = input;
                } else {
                    System.out.println("Error: invalid attribute");
                }

                System.out.print("Continue? (Y/N) ");
                input = in.nextLine();
                if(input.equalsIgnoreCase("Y")){
                    break;
                }
            }
        }
    }

    public static void deleteMember(Scanner in){
        Member m = searchMembers(in);
        if(m != null){
            members.remove(m);
        }
    }

    public static Member searchMembers(Scanner in){
        System.out.print("Enter member userID: ");
        String input = in.nextLine();
        int id;
        try{
            id = Integer.parseInt(input);
            for(Member m: members){
                if(m.userID == id){
                    return m;
                }
            }
            System.out.print("Error: no employee with id " + id);
        } catch(NumberFormatException ex) {
            System.out.print("Error: invalid id " + input);
        }
        return null;
    }

    public static void displayMember(Member m){
        System.out.print(m.userID + " ");
        System.out.print(m.fname + " ");
        System.out.print(m.lname + " ");
        System.out.print(m.address + " ");
        System.out.print(m.email + " ");
        System.out.print(m.password + " ");
        System.out.print(m.phone + " ");
        System.out.println(m.startDate);
    }

    //Warehouse Methods

    public static void addWarehouse(Scanner in){
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

    public static void editWarehouse(Scanner in){
        Warehouse w = searchWarehouses(in);
        String input;
        if(w != null){
            while(true){
                displayWarehouse(w);
                System.out.print("Enter field to edit: ");
                input = in.nextLine();
                if(input.equalsIgnoreCase("city")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    w.city = input;
                } else if(input.equalsIgnoreCase("address")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    w.address = input;
                } else if(input.equalsIgnoreCase("phone")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    w.phone = input;
                } else if(input.equalsIgnoreCase("Drone Capacity")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    w.droneCapacity = input;
                } else if(input.equalsIgnoreCase("Storage Capacity")){
                    System.out.println("Enter new data: ");
                    input = in.nextLine();
                    w.storageCapacity = input;
                } else {
                    System.out.println("Error: invalid attribute");
                }

                System.out.print("Continue? (Y/N) ");
                input = in.nextLine();
                if(input.equalsIgnoreCase("Y")){
                    break;
                }
            }
        }
    }

    public static void deleteWarehouse(Scanner in){
        Warehouse w = searchWarehouses(in);
        if(w != null){
            warehouses.remove(w);
        }
    }

    public static Warehouse searchWarehouses(Scanner in){
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

    public static void displayWarehouse(Warehouse w){
        System.out.print(w.address + " ");
        System.out.print(w.city + " ");
        System.out.print(w.phone + " ");
        System.out.println(w.droneCapacity);
    }


    public static int id_num = 0;
    public static ArrayList<Drone> drones = new ArrayList<Drone>();
    public static ArrayList<Employee> employees = new ArrayList<Employee>();
    public static ArrayList<Equipment> equipment = new ArrayList<Equipment>();
    public static ArrayList<Member> members = new ArrayList<Member>();
    public static ArrayList<Order> orders = new ArrayList<Order>();
    public static ArrayList<Warehouse> warehouses = new ArrayList<Warehouse>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String input;
        System.out.println("Hello, welcome to Drone Delivery Services.");
        System.out.println("Databases are:\n\tEmployees\n\tMembers\n\tWarehouses\n\tEquipment\n\tDrones\n\tOrders\n");


        while(true){
            System.out.println("Please enter a table to display ('Q' to quit)");
            input = in.nextLine();

            //Exit case
            if(input.equals("Q")){
                break;

            //Display tables case
            } else if(input.equalsIgnoreCase("Employees")){
                System.out.println("Employees:");
                for(Employee e: employees){
                    displayEmployee(e);
                }
                while(true){
                    
                    System.out.println("Enter 'I' to input new data\n\t'E' to edit existing data\n\t'D' to delete data\n\t'S' to search data\n\t'B' to go back");
                    input = in.nextLine();
                    if(input.equalsIgnoreCase("I")){
                        addEmployee(in);
                    } else if (input.equalsIgnoreCase("E")){
                        editEmployee(in);
                    } else if (input.equalsIgnoreCase("D")){
                        deleteEmployee(in);
                    } else if (input.equalsIgnoreCase("S")){
                        Employee e = searchEmployees(in);
                        displayEmployee(e);
                    } else if (input.equalsIgnoreCase("B")){
                        break;
                    } else {
                        System.out.println("Error: invalid input");
                    }
                }

            } else if(input.equalsIgnoreCase("Members")){
                System.out.println("Members:");
                for(Member m: members){
                    displayMember(m);
                }
                while(true){
                    System.out.println("Enter 'I' to input new data\n\t'E' to edit existing data\n\t'D' to delete data\n\t'S' to search data\n\t'B' to go back");
                    input = in.nextLine();
                    if(input.equalsIgnoreCase("I")){
                        addMember(in);
                    } else if (input.equalsIgnoreCase("E")){
                        editMember(in);
                    } else if (input.equalsIgnoreCase("D")){
                        deleteMember(in);
                    } else if (input.equalsIgnoreCase("S")){
                        Member m = searchMembers(in);
                        displayMember(m);
                    } else if (input.equalsIgnoreCase("B")){
                        break;
                    } else {
                        System.out.println("Error: invalid input");
                    }
                }

            } else if(input.equalsIgnoreCase("Warehouses")){
                System.out.println("Members:");
                for(Warehouse w: warehouses){
                    displayWarehouse(w);
                }
                while(true){
                    System.out.println("Enter 'I' to input new data\n\t'E' to edit existing data\n\t'D' to delete data\n\t'S' to search data\n\t'B' to go back");
                    input = in.nextLine();
                    if(input.equalsIgnoreCase("I")){
                        addWarehouse(in);
                    } else if (input.equalsIgnoreCase("E")){
                        editWarehouse(in);
                    } else if (input.equalsIgnoreCase("D")){
                        deleteWarehouse(in);
                    } else if (input.equalsIgnoreCase("S")){
                        Warehouse w = searchWarehouses(in);
                        displayWarehouse(w);
                    } else if (input.equalsIgnoreCase("B")){
                        break;
                    } else {
                        System.out.println("Error: invalid input");
                    }
                }

            } else if(input.equalsIgnoreCase("Equipments")){

            } else if(input.equalsIgnoreCase("Drones")){

            } else if(input.equalsIgnoreCase("Orders")){

            //Invalid input case
            } else {
                System.out.println("Error: invalid input");
            }
        }

        in.close();
    }
}
