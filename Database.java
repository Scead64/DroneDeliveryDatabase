import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DataClasses.Drone;
import DataClasses.Equipment;
import DataClasses.Member;
import DataClasses.Order;
import DataClasses.Warehouse;
import ManagerClasses.DroneManager;
import ManagerClasses.EmployeeManager;
import ManagerClasses.EquipmentManager;
import ManagerClasses.MemberManager;
import ManagerClasses.OrderManager;
import ManagerClasses.UsefulReports;
import ManagerClasses.WarehouseManager;

public class Database {

    //Database file name
    private static String DATABASE = "DroneDatabase.db";

    private static String currentClass;

    //Number to keep track of id numbers
    public static int id_num = 0;

    /**
     * Connects to the database if it exists, creates it if it does not, and
     * returns the connection object.
     *
     * @param databaseFileName
     *            the database file name
     * @return a connection object to the designated database
     */
    public static Connection initializeDB(String databaseFileName) {
        /**
         * The "Connection String" or "Connection URL".
         *
         * "jdbc:sqlite:" is the "subprotocol". (If this were a SQL Server
         * database it would be "jdbc:sqlserver:".)
         */
        String url = "jdbc:sqlite:" + databaseFileName;
        Connection conn = null; // If you create this variable inside the Try block it will be out of scope
        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                // Provides some positive assurance the connection and/or creation was successful.
                DatabaseMetaData meta = conn.getMetaData();
                System.out
                        .println("The driver name is " + meta.getDriverName());
                System.out.println(
                        "The connection to the database was successful.");
            } else {
                // Provides some feedback in case the connection failed but did not throw an exception.
                System.out.println("Null Connection");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out
                    .println("There was a problem connecting to the database.");
        }
        return conn;
    }

    public static void main(String[] args) {

        Connection conn = initializeDB(DATABASE);
        PreparedStatement stmt = null;
        ResultSet rSet = null;

        Scanner in = new Scanner(System.in);
        String input, query;
        System.out.println("Hello, welcome to Drone Delivery Services.");

        while (true) {

            System.out.println(
                    "Databases:\n\tEmployee\n\tMember\n\tWarehouse\n\tEquipment\n\tDrone\n\tOrders\n");
            System.out.println(
                    "Useful Reports: \n\tRenting Checkouts\n\tMost Popular Item\n\tMost Popular Manufacturer\n\t"
                            + "Most Popular Drone\n\tItems Checked Out\n\tEquipment By Type\n");
            System.out.print(
                    "Please enter a table to display or press 'U' to view some useful reports ('Q' to quit): ");
            input = in.nextLine();

            //Exit case
            if (input.equalsIgnoreCase("Q")) {
                break;

            //Useful reports case
            } else if (input.equalsIgnoreCase("U")) {
                while (true) {
                    System.out.println("Reports are:"
                            + "\n\t1: Number of items rented by one member."
                            + "\n\t2: Most popular item in database."
                            + "\n\t3: Most frequent equipment manufacturer."
                            + "\n\t4: Most used drone."
                            + "\n\t5: Member who has rented the most items and the number of items rented."
                            + "\n\t6: Equipment of a certain type released before a certain year."
                            + "\n\tQ: Back\n");
                    input = in.next();

                    if (input.equalsIgnoreCase("1")) {
                        System.out.print(
                                "Give user id to find number of items for (21-40): ");
                        int userId = in.nextInt();
                        UsefulReports.rentingCheckouts(conn, userId);
                    } else if (input.equalsIgnoreCase("2")) {
                        UsefulReports.popularItem(conn);

                    } else if (input.equalsIgnoreCase("3")) {
                        UsefulReports.popularManufacturer(conn);

                    } else if (input.equalsIgnoreCase("4")) {
                        UsefulReports.popularDrone(conn);

                    } else if (input.equalsIgnoreCase("5")) {
                        UsefulReports.itemsCheckedOut(conn);

                    } else if (input.equalsIgnoreCase("6")) {
                        System.out.print(
                                "Write the type of item to search for: ");
                        in.nextLine();
                        String type = in.nextLine();
                        System.out.print(
                                "Write the desired year in yyyy format: ");

                        String year = in.nextLine();
                        UsefulReports.equipmentByType(conn, type, year);

                    } else if (input.equalsIgnoreCase("Q")) {
                        break;
                    } else {
                        System.out.println("Error: invalid input");
                    }
                }
            }

            else if (input.equalsIgnoreCase("Employee")) {
                currentClass = "Employee";
                while (true) {
                    System.out.println(
                            "Enter 'Display' to display all\n\t 'Input' to input new data\n\t'Select' to edit or delete existing data\n\t'Search' to search data\n\t'Back' to go back");
                    input = in.nextLine();

                    if (input.equalsIgnoreCase("Display")) {
                        EmployeeManager.displayAll(conn, currentClass);

                    } else if (input.equalsIgnoreCase("Input")) {
                        EmployeeManager.add(in, conn, currentClass);

                    } else if (input.equalsIgnoreCase("Select")) {
                        EmployeeManager.select(in, conn, stmt, rSet);

                    } else if (input.equalsIgnoreCase("Search")) {
                        // EmployeeManager.search(in, conn, stmt, rSet);

                    } else if (input.equalsIgnoreCase("Back")) {
                        break;

                    } else {
                        System.out.println("Error: invalid input");
                    }
                }

            } else if (input.equalsIgnoreCase("Member")) {
                while (true) {
                    System.out.println(
                            "Enter 'Display' to display all\n\t 'Input' to input new data\n\t'Edit' to edit existing data\n\t'Delete' to delete data\n\t'Search' to search data\n\t'Back' to go back");
                    input = in.nextLine();

                    if (input.equalsIgnoreCase("Display")) {
                        MemberManager.displayAll();

                    } else if (input.equalsIgnoreCase("Input")) {
                        MemberManager.add(in, id_num);
                        id_num++;

                    } else if (input.equalsIgnoreCase("Search")) {
                        MemberManager.search(in);

                    } else if (input.equalsIgnoreCase("Select")) {
                        Member m = MemberManager.select(in);

                        if (m != null) {
                            System.out.println(
                                    "Enter 'Edit' to edit\n\t 'Delete' to delete\n\t 'Reviews' to look at reviews \n\t 'Back' to go back");
                            input = in.nextLine();

                            if (input.equalsIgnoreCase("Edit")) {
                                m.edit(in);

                            } else if (input.equalsIgnoreCase("Delete")) {
                                MemberManager.members.remove(m);

                            } else {
                                if (!input.equalsIgnoreCase("Back")) {
                                    System.out.println("Error: invalid input");
                                }

                            }
                        }

                    } else if (input.equalsIgnoreCase("Back")) {
                        break;
                    } else {
                        System.out.println("Error: invalid input");
                    }
                }

            } else if (input.equalsIgnoreCase("Warehouse")) {
                while (true) {
                    System.out.println(
                            "Enter 'Display' to display all\n\t 'Input' to input new data\n\t'Edit' to edit existing data\n\t'Delete' to delete data\n\t'Search' to search data\n\t'Back' to go back");
                    input = in.nextLine();

                    if (input.equalsIgnoreCase("Display")) {
                        WarehouseManager.displayAll();
                    } else if (input.equalsIgnoreCase("Input")) {
                        WarehouseManager.add(in);
                    } else if (input.equalsIgnoreCase("Search")) {
                        WarehouseManager.search(in);
                    } else if (input.equalsIgnoreCase("Select")) {
                        Warehouse w = WarehouseManager.select(in);
                        if (w != null) {
                            System.out.println(
                                    "Enter 'Edit' to edit\n\t 'Delete' to delete\n\t 'Back' to go back");
                            input = in.nextLine();

                            if (input.equalsIgnoreCase("Edit")) {
                                w.edit(in);
                            } else if (input.equalsIgnoreCase("Delete")) {
                                WarehouseManager.warehouses.remove(w);
                            } else {
                                if (!input.equalsIgnoreCase("Back")) {
                                    System.out.println("Error: invalid input");
                                }
                            }
                        }

                    } else if (input.equalsIgnoreCase("Back")) {
                        break;

                    } else {
                        System.out.println("Error: invalid input");
                    }
                }

            } else if (input.equalsIgnoreCase("Equipment")) {
                while (true) {
                    System.out.println(
                            "Enter 'Display' to display all\n\t 'Input' to input new data\n\t'Edit' to edit existing data\n\t'Delete' to delete data\n\t'Search' to search data\n\t'Back' to go back");
                    input = in.nextLine();

                    if (input.equalsIgnoreCase("Display")) {
                        EquipmentManager.displayAll();

                    } else if (input.equalsIgnoreCase("Input")) {
                        EquipmentManager.add(in);
                    } else if (input.equalsIgnoreCase("Search")) {
                        EquipmentManager.search(in);
                    } else if (input.equalsIgnoreCase("Select")) {
                        Equipment e = EquipmentManager.select(in);
                        if (e != null) {
                            System.out.println(
                                    "Enter 'Edit' to edit\n\t 'Delete' to delete\n\t 'Back' to go back");
                            input = in.nextLine();

                            if (input.equalsIgnoreCase("Edit")) {
                                e.edit(in);
                            } else if (input.equalsIgnoreCase("Delete")) {
                                EquipmentManager.equipment.remove(e);
                            } else {
                                if (!input.equalsIgnoreCase("Back")) {
                                    System.out.println("Error: invalid input");
                                }
                            }
                        }

                    } else if (input.equalsIgnoreCase("Back")) {
                        break;

                    } else {
                        System.out.println("Error: invalid input");
                    }
                }
            } else if (input.equalsIgnoreCase("Drone")) {
                while (true) {
                    System.out.println(
                            "Enter 'Display' to display all\n\t 'Input' to input new data\n\t'Edit' to edit existing data\n\t'Delete' to delete data\n\t'Search' to search data\n\t'Back' to go back");
                    input = in.nextLine();

                    if (input.equalsIgnoreCase("Display")) {
                        DroneManager.displayAll();

                    } else if (input.equalsIgnoreCase("Input")) {
                        DroneManager.add(in);
                    } else if (input.equalsIgnoreCase("Search")) {
                        DroneManager.search(in);
                    } else if (input.equalsIgnoreCase("Select")) {
                        Drone d = DroneManager.select(in);
                        if (d != null) {
                            System.out.println(
                                    "Enter 'Edit' to edit\n\t 'Delete' to delete\n\t 'Back' to go back");
                            input = in.nextLine();

                            if (input.equalsIgnoreCase("Edit")) {
                                d.edit(in);
                            } else if (input.equalsIgnoreCase("Delete")) {
                                DroneManager.drones.remove(d);
                            } else {
                                if (!input.equalsIgnoreCase("Back")) {
                                    System.out.println("Error: invalid input");
                                }
                            }
                        }

                    } else if (input.equalsIgnoreCase("Back")) {
                        break;

                    } else {
                        System.out.println("Error: invalid input");
                    }
                }
            } else if (input.equalsIgnoreCase("Orders")) {
                while (true) {
                    System.out.println(
                            "Enter 'Display' to display all\n\t 'Input' to input new data\n\t'Edit' to edit existing data\n\t'Delete' to delete data\n\t'Search' to search data\n\t'Back' to go back");
                    input = in.nextLine();

                    if (input.equalsIgnoreCase("Display")) {
                        OrderManager.displayAll();

                    } else if (input.equalsIgnoreCase("Input")) {
                        OrderManager.add(in);
                    } else if (input.equalsIgnoreCase("Search")) {
                        OrderManager.search(in);
                    } else if (input.equalsIgnoreCase("Select")) {
                        Order o = OrderManager.select(in);
                        if (o != null) {
                            System.out.println(
                                    "Enter 'Edit' to edit\n\t 'Delete' to delete\n\t 'Back' to go back");
                            input = in.nextLine();

                            if (input.equalsIgnoreCase("Edit")) {
                                o.edit(in);
                            } else if (input.equalsIgnoreCase("Delete")) {
                                OrderManager.orders.remove(o);
                            } else {
                                if (!input.equalsIgnoreCase("Back")) {
                                    System.out.println("Error: invalid input");
                                }
                            }
                        }

                    } else if (input.equalsIgnoreCase("Back")) {
                        break;

                    } else {
                        System.out.println("Error: invalid input");
                    }
                }
            } else {
                System.out.println("Error: invalid input");
            }
        }

        //Close opened resources and exit
        try{
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        in.close();
        System.out.println("Have a nice day!");
    }
}
