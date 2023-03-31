package ManagerClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import DataClasses.*;

public class EmployeeManager {
    public static ArrayList<Employee> employees = new ArrayList<Employee>();

    // Employee methods

    public static void add(Scanner in, Connection conn, PreparedStatement stmt) {  
        System.out.print("email: ");
        String email = in.nextLine();
        System.out.print("phone: ");
        String phone = in.nextLine();
        System.out.print("address: ");
        String address = in.nextLine();
        System.out.print("fname: ");
        String fname = in.nextLine();
        System.out.print("lname: ");
        String lname = in.nextLine();
        System.out.print("Salary: ");
        String salary = in.nextLine();
        System.out.print("password: ");
        String password = in.nextLine();
        System.out.print("YOE: ");
        String YOE = in.nextLine();
        System.out.print("warehouse_address: ");
        String warehouseAddr = in.nextLine();
        System.out.print("user_id: ");
        String id = in.nextLine();

        try{
            stmt = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES (" + 
                                                email + ", " +
                                                phone + ", " +
                                                address + ", " +
                                                fname + ", " +
                                                lname + ", " +
                                                salary + ", " +
                                                password + ", " +
                                                YOE + ", " +
                                                warehouseAddr + ", " +
                                                id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // public static Employee select(Scanner in) {
    //     System.out.print("Enter employee userID: ");
    //     String input = in.nextLine();
    //     int id;
    //     try {
    //         id = Integer.parseInt(input);
    //         for (Employee e : employees) {
    //             if (e.userID == id) {
    //                 return e;
    //             }
    //         }
    //         System.out.print("Error: no employee with id " + id);
    //     } catch (NumberFormatException ex) {
    //         System.out.print("Error: invalid id " + input);
    //     }
    //     return null;
    // }

    public static Employee select(Scanner in, Connection conn, PreparedStatement stmt, ResultSet rSet) {
        System.out.print("Enter employee userID: ");
        String input = in.nextLine();

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
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static void search(Scanner in) {
        System.out.print("Enter attribute to search: ");
        String input = in.nextLine();
        System.out.println("Enter data: ");
        String data = in.nextLine();

        if (input.equalsIgnoreCase("fname")) {
            for (Employee e : employees) {
                if (e.fname.equalsIgnoreCase(data)) {
                    e.display();
                }
            }
        } else if (input.equalsIgnoreCase("lname")) {
            for (Employee e : employees) {
                if (e.lname.equalsIgnoreCase(data)) {
                    e.display();
                }
            }
        } else if (input.equalsIgnoreCase("address")) {
            for (Employee e : employees) {
                if (e.address.equalsIgnoreCase(data)) {
                    e.display();
                }
            }
        } else if (input.equalsIgnoreCase("email")) {
            for (Employee e : employees) {
                if (e.email.equalsIgnoreCase(data)) {
                    e.display();
                }
            }
        } else if (input.equalsIgnoreCase("password")) {
            for (Employee e : employees) {
                if (e.password.equalsIgnoreCase(data)) {
                    e.display();
                }
            }
        } else if (input.equalsIgnoreCase("phone")) {
            for (Employee e : employees) {
                if (e.phone.equalsIgnoreCase(data)) {
                    e.display();
                }
            }
        } else if (input.equalsIgnoreCase("YOE")) {
            for (Employee e : employees) {
                if (e.YOE.equalsIgnoreCase(data)) {
                    e.display();
                }
            }
        } else if (input.equalsIgnoreCase("salary")) {
            for (Employee e : employees) {
                if (e.salary.equalsIgnoreCase(data)) {
                    e.display();
                }
            }
        } else if (input.equalsIgnoreCase("userID")) {
            for (Employee e : employees) {
                if (String.valueOf(e.userID).equalsIgnoreCase(data)) {
                    e.display();
                }
            }
        } else {
            System.out.println("Error: invalid attribute");
        }
    }

    // public static void displayAll() {
    // for(Employee e: employees){
    // e.display();
    // }
    // }
    public static void displayAll(Connection conn, PreparedStatement stmt, ResultSet rSet) {
        try{
            stmt = conn.prepareStatement("SELECT * FROM EMPLOYEE");
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
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}