import java.util.Scanner;
import java.util.ArrayList;
import DataClasses.*;
import ManagerClasses.*;

public class Database{

    
    
    public static int id_num = 0;
    public static ArrayList<Drone> drones = new ArrayList<Drone>();
    public static ArrayList<Order> orders = new ArrayList<Order>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String input;
        System.out.println("Hello, welcome to Drone Delivery Services.");
        System.out.println("Databases are:\n\tEmployees\n\tMembers\n\tWarehouses\n\tEquipment\n\tDrones\n\tOrders\n");


        while(true){
            System.out.println("Please enter a table to display ('Q' to quit)");
            input = in.nextLine();

            //Exit case
            if(input.equalsIgnoreCase("Q")){
                break;

            //Display tables case
            } else if(input.equalsIgnoreCase("Employees")){
                while(true){
                    System.out.println("Enter 'Display' to display all\n\t 'Input' to input new data\n\t'Edit' to edit existing data\n\t'Delete' to delete data\n\t'Search' to search data\n\t'Back' to go back");
                    input = in.nextLine();

                    if (input.equalsIgnoreCase("Display")){
                        System.out.println("Employees:");
                        for(Employee e: EmployeeManager.employees){
                            e.display();
                        }
                    } else if(input.equalsIgnoreCase("Input")){
                        EmployeeManager.add(in, id_num);
                        id_num++;
                    } else if (input.equalsIgnoreCase("Search")){
                        EmployeeManager.search(in);
                    } else if (input.equalsIgnoreCase("Select")){
                        Employee e = EmployeeManager.select(in);
                        if(e != null){
                            System.out.println("Enter 'Edit' to edit employee\n\t 'Delete' to delete employee\n\t 'Back' to go back");
                            input = in.nextLine();

                            if(input.equalsIgnoreCase("Edit")){
                                e.edit(in);
                            } else if(input.equalsIgnoreCase("Delete")){
                                EmployeeManager.employees.remove(e);
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
                        for(Member m: MemberManager.members){
                            m.display();
                        }
                    } else if(input.equalsIgnoreCase("Input")){
                        MemberManager.add(in, id_num);
                        id_num++;
                    } else if (input.equalsIgnoreCase("Search")){
                        MemberManager.search(in);
                    } else if (input.equalsIgnoreCase("Select")){
                        Member m = MemberManager.select(in);
                        if(m != null){
                            System.out.println("Enter 'Edit' to edit\n\t 'Delete' to delete\n\t 'Back' to go back");
                            input = in.nextLine();

                            if(input.equalsIgnoreCase("Edit")){
                                m.edit(in);
                            } else if(input.equalsIgnoreCase("Delete")){
                                MemberManager.members.remove(m);
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
                        for(Warehouse e: WarehouseManager.warehouses){
                            e.display();
                        }
                    } else if(input.equalsIgnoreCase("Input")){
                        WarehouseManager.add(in);
                    } else if (input.equalsIgnoreCase("Search")){
                        WarehouseManager.search(in);
                    } else if (input.equalsIgnoreCase("Select")){
                        Warehouse w = WarehouseManager.select(in);
                        if(w != null){
                            System.out.println("Enter 'Edit' to edit\n\t 'Delete' to delete\n\t 'Back' to go back");
                            input = in.nextLine();

                            if(input.equalsIgnoreCase("Edit")){
                                w.edit(in);
                            } else if(input.equalsIgnoreCase("Delete")){
                                WarehouseManager.warehouses.remove(w);
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

            } else if(input.equalsIgnoreCase("Equipment")){
                while(true){
                    System.out.println("Enter 'Display' to display all\n\t 'Input' to input new data\n\t'Edit' to edit existing data\n\t'Delete' to delete data\n\t'Search' to search data\n\t'Back' to go back");
                    input = in.nextLine();

                    if (input.equalsIgnoreCase("Display")){
                        System.out.println("Equipments:");
                        for(Equipment e: EquipmentManager.equipment){
                            e.display();
                        }
                    } else if(input.equalsIgnoreCase("Input")){
                        EquipmentManager.add(in);
                    } else if (input.equalsIgnoreCase("Search")){
                        EquipmentManager.search(in);
                    } else if (input.equalsIgnoreCase("Select")){
                        Equipment e = EquipmentManager.select(in);
                        if(e != null){
                            System.out.println("Enter 'Edit' to edit\n\t 'Delete' to delete\n\t 'Back' to go back");
                            input = in.nextLine();

                            if(input.equalsIgnoreCase("Edit")){
                                e.edit(in);
                            } else if(input.equalsIgnoreCase("Delete")){
                                EquipmentManager.equipment.remove(e);
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
            } else if(input.equalsIgnoreCase("Drones")){
                System.out.println("Error: functionality not currently provided");
            } else if(input.equalsIgnoreCase("Orders")){
                System.out.println("Error: functionality not currently provided");
            } else {
                System.out.println("Error: invalid input");
            }
        }

        in.close();
    }
}
