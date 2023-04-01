import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

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
    
    //Gets the primary key given the current class
    public static void select(Scanner in, Connection conn){
        String input;
        if (currentClass == "Employee") {
            System.out.print("Enter Employee userID: ");
            input = in.nextLine();
            if(!QueryManager.select(in, conn, currentClass, " WHERE user_id =?", input)){
                System.out.println("Error: no Employee with userID " + input);
            }

        } else if (currentClass == "Member") {
            System.out.print("Enter Member userID: ");
            input = in.nextLine();
            if(!QueryManager.select(in, conn, currentClass, " WHERE user_id =?", input)){
                System.out.println("Error: no Member with userID " + input);
            }

        } else if (currentClass == "Warehouse") {
            System.out.print("Enter Warehouse address: ");
            input = in.nextLine();
            if(!QueryManager.select(in, conn, currentClass, " WHERE user_id =?", input)){
                System.out.println("Error: no Warehouse with address " + input);
            }

        } else if (currentClass == "Equipment") {
            System.out.print("Enter Equipment serial number: ");
            input = in.nextLine();
            if(!QueryManager.select(in, conn, currentClass, " WHERE serial_number =?", input)){
                System.out.println("Error: no Equipment with serial_number " + input);
            }

        } else if (currentClass == "Drone") {
            System.out.print("Enter Drone serial number: ");
            input = in.nextLine();
            if(!QueryManager.select(in, conn, currentClass, " WHERE serial_num =?", input)){
                System.out.println("Error: no Drone with serial number " + input);
            }

        } else if (currentClass == "Orders") {
            System.out.print("Enter Orders order number: ");
            input = in.nextLine();
            if(!QueryManager.select(in, conn, currentClass, " WHERE order_number =?", input)){
                System.out.println("Error: no Order with order number " + input);
            }

        }
    }

    public static void main(String[] args) {

        // SQL connection variables
        Connection conn = initializeDB(DATABASE);

        // I/O variables
        Scanner in = new Scanner(System.in);
        String input, query;
        

        System.out.println("Hello, welcome to Drone Delivery Services.");
        while (true) {
            System.out.println("Databases are:"
                    + "\n\tEmployee"
                    + "\n\tMember"
                    + "\n\tWarehouse"
                    + "\n\tEquipment"
                    + "\n\tDrone"
                    + "\n\tOrders\n");
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
            } else {
                if (input.equalsIgnoreCase("Employee")) {
                    currentClass = "Employee";
                } else if (input.equalsIgnoreCase("Member")) {
                    currentClass = "Member";
                } else if (input.equalsIgnoreCase("Warehouse")) {
                    currentClass = "Warehouse";
                } else if (input.equalsIgnoreCase("Equipment")) {
                    currentClass = "Equipment";
                } else if (input.equalsIgnoreCase("Drone")) {
                    currentClass = "Drone";
                } else if (input.equalsIgnoreCase("Orders")) {
                    currentClass = "Orders";
                } else {
                    System.out.print("Error: invalid input");
                }

                if(currentClass != null){
                    while (true) {
                        System.out.println("\tDisplay: Display all"
                                + "\n\tInput: Input new data"
                                + "\n\tSelect: Edit or delete existing data"
                                + "\n\tSearch: Query data"
                                + "\n\tBack: Return to main menu");
                        input = in.nextLine();
    
                        if (input.equalsIgnoreCase("Display")) {
                            QueryManager.display(conn, "SELECT * FROM " + currentClass);
    
                        } else if (input.equalsIgnoreCase("Input")) {
                            QueryManager.add(in, conn, currentClass);
    
                        } else if (input.equalsIgnoreCase("Select")) {
                            select(in, conn);

                        } else if (input.equalsIgnoreCase("Search")) {
                            query = "SELECT * FROM " + currentClass + " WHERE ";
                            while(true){
                                System.out.print("Enter search condition: ");    
                                query += in.nextLine();
    
                                System.out.print("Enter 'C' to continue inputting conditions: ");
                                input = in.nextLine();
                                if(input.equalsIgnoreCase("C")){
                                    query+= " AND ";
                                } else {
                                    break;
                                }
                            }
                            System.out.println("Query is: " + query);
                            QueryManager.display(conn, query);
                            
                        } else if (input.equalsIgnoreCase("Back")) {
                            currentClass = null;
                            break;

                        } else {
                            System.out.println("Error: invalid input");
                        }
                    }
                }
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
