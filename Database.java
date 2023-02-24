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
        Employee e = new Employee(id_num, fname, lname, address, email, password, phone, YOE, salary);
        employees.add(e);
        id_num++;
    }

    public static Employee selectEmployee(Scanner in){
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

    public static void searchEmployees(Scanner in){
        System.out.print("Enter attribute to search: ");
        String input = in.nextLine();
        System.out.println("Enter data: ");
        String data = in.nextLine();

        if(input.equalsIgnoreCase("fname")){
            for(Employee e: employees){
                if(e.fname.equalsIgnoreCase(data)){
                    e.display();
                }
            }
        } else if(input.equalsIgnoreCase("lname")){
            for(Employee e: employees){
                if(e.lname.equalsIgnoreCase(data)){
                    e.display();
                }
            }
        } else if(input.equalsIgnoreCase("address")){
            for(Employee e: employees){
                if(e.address.equalsIgnoreCase(data)){
                    e.display();
                }
            }
        } else if(input.equalsIgnoreCase("email")){
            for(Employee e: employees){
                if(e.email.equalsIgnoreCase(data)){
                    e.display();
                }
            }
        } else if(input.equalsIgnoreCase("password")){
            for(Employee e: employees){
                if(e.password.equalsIgnoreCase(data)){
                    e.display();
                }
            }
        } else if(input.equalsIgnoreCase("phone")){
            for(Employee e: employees){
                if(e.phone.equalsIgnoreCase(data)){
                    e.display();
                }
            }
        } else if(input.equalsIgnoreCase("YOE")){
            for(Employee e: employees){
                if(e.YOE.equalsIgnoreCase(data)){
                    e.display();
                }
            }
        } else if(input.equalsIgnoreCase("salary")){
            for(Employee e: employees){
                if(e.salary.equalsIgnoreCase(data)){
                    e.display();
                }
            }
        } else if(input.equalsIgnoreCase("userID")){
            for(Employee e: employees){
                if(String.valueOf(e.userID).equalsIgnoreCase(data)){
                    e.display();
                }
            }
        } else {
            System.out.println("Error: invalid attribute");
        }
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

    public static Member selectMember(Scanner in){
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
            System.out.print("Error: no member with id " + id);
        } catch(NumberFormatException ex) {
            System.out.print("Error: invalid id " + input);
        }
        return null;
    }

    public static void searchMembers(Scanner in){
        System.out.print("Enter attribute to search: ");
        String input = in.nextLine();
        System.out.println("Enter data: ");
        String data = in.nextLine();

        if(input.equalsIgnoreCase("fname")){
            for(Member m: members){
                if(m.fname.equalsIgnoreCase(data)){
                    m.display();
                }
            }
        } else if(input.equalsIgnoreCase("lname")){
            for(Member m: members){
                if(m.lname.equalsIgnoreCase(data)){
                    m.display();
                }
            }
        } else if(input.equalsIgnoreCase("address")){
            for(Member m: members){
                if(m.address.equalsIgnoreCase(data)){
                    m.display();
                }
            }
        } else if(input.equalsIgnoreCase("email")){
            for(Member m: members){
                if(m.email.equalsIgnoreCase(data)){
                    m.display();
                }
            }
        } else if(input.equalsIgnoreCase("password")){
            for(Member m: members){
                if(m.password.equalsIgnoreCase(data)){
                    m.display();
                }
            }
        } else if(input.equalsIgnoreCase("phone")){
            for(Member m: members){
                if(m.phone.equalsIgnoreCase(data)){
                    m.display();
                }
            }
        } else if(input.equalsIgnoreCase("Start date")){
            for(Member m: members){
                if(m.startDate.equalsIgnoreCase(data)){
                    m.display();
                }
            }
        } else if(input.equalsIgnoreCase("userID")){
            for(Member m: members){
                if(m.fname.equalsIgnoreCase(data)){
                    m.display();
                }
            }
        } else {
            System.out.println("Error: invalid attribute");
        }
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

    public static Warehouse selectWarehouse(Scanner in){
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

    public static void searchWarehouses(Scanner in){
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
                while(true){
                    System.out.println("Enter 'Display' to display all\n\t 'Input' to input new data\n\t'Edit' to edit existing data\n\t'Delete' to delete data\n\t'Search' to search data\n\t'Back' to go back");
                    input = in.nextLine();

                    if (input.equalsIgnoreCase("Display")){
                        System.out.println("Employees:");
                        for(Employee e: employees){
                            e.display();
                        }
                    } else if(input.equalsIgnoreCase("Input")){
                        addEmployee(in);
                    } else if (input.equalsIgnoreCase("Search")){
                        searchEmployees(in);
                    } else if (input.equalsIgnoreCase("Select")){
                        Employee e = selectEmployee(in);
                        if(e != null){
                            System.out.println("Enter 'Edit' to edit employee\n\t 'Delete' to delete employee\n\t 'Back' to go back");
                            input = in.nextLine();

                            if(input.equalsIgnoreCase("Edit")){
                                e.edit(in);
                            } else if(input.equalsIgnoreCase("Delete")){
                                employees.remove(e);
                            } else {
                                if(!input.equalsIgnoreCase("Back")){
                                    System.out.println("Error: invalid input");
                                }
                            }
                        }

                    } else if (input.equalsIgnoreCase("Back")){
                        break;
                    
                    } else {
                        System.out.println("Error: invalid input");
                    }
                }

            } else if(input.equalsIgnoreCase("Members")){
                while(true){
                    System.out.println("Enter 'Display' to display all\n\t 'Input' to input new data\n\t'Edit' to edit existing data\n\t'Delete' to delete data\n\t'Search' to search data\n\t'Back' to go back");
                    input = in.nextLine();

                    if (input.equalsIgnoreCase("Display")){
                        System.out.println("Members:");
                        for(Member m: members){
                            m.display();
                        }
                    } else if(input.equalsIgnoreCase("Input")){
                        addMember(in);
                    } else if (input.equalsIgnoreCase("Search")){
                        searchMembers(in);
                    } else if (input.equalsIgnoreCase("Select")){
                        Member m = selectMember(in);
                        if(m != null){
                            System.out.println("Enter 'Edit' to edit\n\t 'Delete' to delete\n\t 'Back' to go back");
                            input = in.nextLine();

                            if(input.equalsIgnoreCase("Edit")){
                                m.edit(in);
                            } else if(input.equalsIgnoreCase("Delete")){
                                members.remove(m);
                            } else {
                                if(!input.equalsIgnoreCase("Back")){
                                    System.out.println("Error: invalid input");
                                }
                            }
                        }

                    } else if (input.equalsIgnoreCase("Back")){
                        break;
                    } else {
                        System.out.println("Error: invalid input");
                    }
                }

            } else if(input.equalsIgnoreCase("Warehouses")){
                while(true){
                    System.out.println("Enter 'Display' to display all\n\t 'Input' to input new data\n\t'Edit' to edit existing data\n\t'Delete' to delete data\n\t'Search' to search data\n\t'Back' to go back");
                    input = in.nextLine();

                    if (input.equalsIgnoreCase("Display")){
                        System.out.println("Warehouses:");
                        for(Warehouse e: warehouses){
                            e.display();
                        }
                    } else if(input.equalsIgnoreCase("Input")){
                        addWarehouse(in);
                    } else if (input.equalsIgnoreCase("Search")){
                        searchWarehouses(in);
                    } else if (input.equalsIgnoreCase("Select")){
                        Warehouse w = selectWarehouse(in);
                        if(w != null){
                            System.out.println("Enter 'Edit' to edit\n\t 'Delete' to delete\n\t 'Back' to go back");
                            input = in.nextLine();

                            if(input.equalsIgnoreCase("Edit")){
                                w.edit(in);
                            } else if(input.equalsIgnoreCase("Delete")){
                                warehouses.remove(w);
                            } else {
                                if(!input.equalsIgnoreCase("Back")){
                                    System.out.println("Error: invalid input");
                                }
                            }
                        }

                    } else if (input.equalsIgnoreCase("Back")){
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
