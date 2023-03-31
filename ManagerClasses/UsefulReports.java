package ManagerClasses;

import java.util.ArrayList;
import java.util.Scanner;
import DataClasses.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class UsefulReports {
    

    public static void rentingCheckouts(Connection conn, int user) {
    	// Renting checkouts: Find the total number of equipment items rented by a single member patron (user designates the member) (see query from Checkpoint #3)
        /*
         * SELECT user_id, COUNT(serial_number) AS total_items_rented
         * FROM Equipment_Rental
         * WHERE user_id = ?;  
         */

         String query = "SELECT user_id, COUNT(serial_number) AS total_items_rented FROM Equipment_Rental WHERE user_id = ?;";
         try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,user);
            ResultSet rSet = stmt.executeQuery();
            while(rSet.next()) {
                int user_id = rSet.getInt("user_id");
                int total_items_rented = rSet.getInt("total_items_rented");
                System.out.println("User ID: " + user_id + " Total Items Rented: " + total_items_rented);

            }

         }
         catch (SQLException e) {
             System.out.println("Error: " + e.getMessage());
         }
         


    }
    
    public static void popularItem() {
    	
    }
    
    public static void popularManufacturer() {
    	
    }
    
    public static void popularDrone() {
    	
    }
    
    public static void itemsCheckedOut() {
    	
    }
    
    public static void equipmentByType() {
    	
    }

    

    

   
}