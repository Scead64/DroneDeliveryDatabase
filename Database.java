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

    /**
     * Queries the database and prints the results.
     *
     * @param conn
     *            a connection object
     * @param sql
     *            a SQL statement that returns rows This query is written with
     *            the Statement class, typically used for static SQL SELECT
     *            statements
     */
    public static void sqlQuery(Connection conn, String sql) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String value = rsmd.getColumnName(i);
                System.out.print(value);
                if (i < columnCount) {
                    System.out.print(",  ");
                }
            }
            System.out.print("\n");
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue);
                    if (i < columnCount) {
                        System.out.print(",  ");
                    }
                }
                System.out.print("\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
                    "Databases:\n\tEmployees\n\tMembers\n\tWarehouses\n\tEquipment\n\tDrones\n\tOrders\n");
            System.out.println("Useful Reports: \n\tRenting Checkouts\n\tMost Popular Item\n\tMost Popular Manufacturer\n\t"
            +"Most Popular Drone\n\tItems Checked Out\n\tEquipment By Type\n");
            System.out.print("Please enter a table to display or press 'U' to view some useful reports ('Q' to quit): ");
            input = in.nextLine();

            //Exit case
            if (input.equalsIgnoreCase("Q")) {
                break;

                //Employee case
            } else if (input.equalsIgnoreCase("Employees")) {
                currentClass = "Employee";
                while (true) {
                    System.out.println(
                            "Enter 'Display' to display all\n\t 'Input' to input new data\n\t'Select' to edit or delete existing data\n\t'Search' to search data\n\t'Back' to go back");
                    input = in.nextLine();

                    if (input.equalsIgnoreCase("Display")) {
                        EmployeeManager.displayAll(conn, stmt, rSet);

                    } else if (input.equalsIgnoreCase("Input")) {
                        EmployeeManager.add(in, conn, stmt);

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

            } else if (input.equalsIgnoreCase("Members")) {
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

            } else if (input.equalsIgnoreCase("Warehouses")) {
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
            } else if (input.equalsIgnoreCase("Drones")) {
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

        in.close();
    }
}
