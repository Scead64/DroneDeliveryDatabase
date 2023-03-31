package ManagerClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {

    /*
     * Displays all data currently in the table
     */
    public static void displayAll(Connection conn, String table) {
        try {
            //Query data
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + table);
            ResultSet rSet = stmt.executeQuery();
            ResultSetMetaData rsmd = rSet.getMetaData();
            int columnCount = rsmd.getColumnCount();

            //Print column metadata
            System.out.println("\nColumns:");
            for (int i = 1; i <= columnCount; i++) {
                String value = rsmd.getColumnName(i);
                System.out.print(value);
                if (i < columnCount) {
                    System.out.print(",  ");
                }
            }

            System.out.println("\n\nData:");
            //Print data
            while (rSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnValue = rSet.getString(i);
                    System.out.print(columnValue);
                    if (i < columnCount) {
                        System.out.print(",  ");
                    }
                }
                System.out.print("\n");
            }
        
            //Close opened resources
            rSet.close();
            stmt.close();

        //Catch any SQL exception and print message
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();
    }

    /*
     * Adds a new row to the table
     */
    public static void add(Scanner in, Connection conn, String table) {
        
        //String variable to keep track of user-inputted values
        String data, fields = "";

        try {

            //Get meta data
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMPLOYEE");
            ResultSet rSet = stmt.executeQuery();
            ResultSetMetaData rsmd = rSet.getMetaData();
            int columnCount = rsmd.getColumnCount();

            //Get field string
            for (int i = 1; i <= columnCount; i++) {
                fields += "?";
                if (i < columnCount) {
                    fields += ",";
                }
            }

            stmt = conn.prepareStatement("INSERT INTO " + table + " VALUES (" + fields + ")");

            //Get user input
            System.out.println();
            for (int i = 1; i <= columnCount; i++) {
                String value = rsmd.getColumnName(i);
                System.out.print(value + ": ");
                data = in.nextLine();
                stmt.setString(i, data);
            }
            stmt.executeUpdate();

            //Close opened resources
            rSet.close();
            stmt.close();

        //Catch any SQL exception and print message
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        // try {
        //     stmt = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES (" +
        //             email + ", " +
        //             phone + ", " +
        //             address + ", " +
        //             fname + ", " +
        //             lname + ", " +
        //             salary + ", " +
        //             password + ", " +
        //             YOE + ", " +
        //             warehouseAddr + ", " +
        //             id + ")");
        // } catch (SQLException ex) {
        //     System.out.println(ex.getMessage());
        // }
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

    
    public static void select(Scanner in, Connection conn, PreparedStatement stmt, ResultSet rSet) {
        String input, user_id;
        System.out.print("Enter employee userID: ");
        input = in.nextLine();

        try{
            stmt = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE user_id = " + input);
            rSet = stmt.executeQuery();
            while(rSet.next()) {
                String email = rSet.getString("email");
                String phone = rSet.getString("phone");
                String address = rSet.getString("address");
                String fname = rSet.getString("fname");
                String lname = rSet.getString("lname");
                String salary = rSet.getString("Salary");
                String password = rSet.getString("password");
                String yoe = rSet.getString("YOE");
                String warehouseAddr = rSet.getString("warehouse_address");
                String id = rSet.getString("user_id");
                System.out.println("email: " + email +
                        " phone: " + phone +
                        " address: " + address +
                        " fname: " + fname +
                        " lname: " + lname +
                        " Salary: " + salary +
                        " password: " + password +
                        " YOE: " + yoe +
                        " warehouse_address: " + warehouseAddr +
                        " user_id: " + id);
            }

            user_id = input;

            while(true){
                System.out.println("Enter 'Edit' to edit employee\n\t 'Delete' to delete employee\n\t 'Back' to go back");
                input = in.nextLine();
                if(input.equalsIgnoreCase("Edit")){
                    //TO DO
        
                } else if(input.equalsIgnoreCase("Delete")){
                    //TO DO
        
                } else if(input.equalsIgnoreCase("Back")){
                        break;
                } else {
                        System.out.println("Error: invalid input");
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // public static void search(Scanner in) {
    //     System.out.print("Enter attribute to search: ");
    //     String input = in.nextLine();
    //     System.out.println("Enter data: ");
    //     String data = in.nextLine();

    //     if (input.equalsIgnoreCase("fname")) {
    //         for (Employee e : employees) {
    //             if (e.fname.equalsIgnoreCase(data)) {
    //                 e.display();
    //             }
    //         }
    //     } else if (input.equalsIgnoreCase("lname")) {
    //         for (Employee e : employees) {
    //             if (e.lname.equalsIgnoreCase(data)) {
    //                 e.display();
    //             }
    //         }
    //     } else if (input.equalsIgnoreCase("address")) {
    //         for (Employee e : employees) {
    //             if (e.address.equalsIgnoreCase(data)) {
    //                 e.display();
    //             }
    //         }
    //     } else if (input.equalsIgnoreCase("email")) {
    //         for (Employee e : employees) {
    //             if (e.email.equalsIgnoreCase(data)) {
    //                 e.display();
    //             }
    //         }
    //     } else if (input.equalsIgnoreCase("password")) {
    //         for (Employee e : employees) {
    //             if (e.password.equalsIgnoreCase(data)) {
    //                 e.display();
    //             }
    //         }
    //     } else if (input.equalsIgnoreCase("phone")) {
    //         for (Employee e : employees) {
    //             if (e.phone.equalsIgnoreCase(data)) {
    //                 e.display();
    //             }
    //         }
    //     } else if (input.equalsIgnoreCase("YOE")) {
    //         for (Employee e : employees) {
    //             if (e.YOE.equalsIgnoreCase(data)) {
    //                 e.display();
    //             }
    //         }
    //     } else if (input.equalsIgnoreCase("salary")) {
    //         for (Employee e : employees) {
    //             if (e.salary.equalsIgnoreCase(data)) {
    //                 e.display();
    //             }
    //         }
    //     } else if (input.equalsIgnoreCase("userID")) {
    //         for (Employee e : employees) {
    //             if (String.valueOf(e.userID).equalsIgnoreCase(data)) {
    //                 e.display();
    //             }
    //         }
    //     } else {
    //         System.out.println("Error: invalid attribute");
    //     }
    // }

    
}