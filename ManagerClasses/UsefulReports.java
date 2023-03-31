package ManagerClasses;

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

    public static void itemsCheckedOut(Connection conn) {
        String query = "SELECT user_id, MAX(total_items)\r\n" + "FROM\r\n"
                + "(SELECT user_id, COUNT(Equipment_Rental.serial_number) AS total_items\r\n"
                + "FROM Equipment_Rental, Equipment\r\n"
                + "WHERE Equipment_Rental.serial_number = Equipment.serial_number\r\n"
                + "AND (description LIKE '%computer%' OR description LIKE '%internet%')\r\n"
                + "GROUP BY Equipment_Rental.user_id);\r\n";
        try {
            PreparedStatement stmnt = conn.prepareStatement(query);
            ResultSet rs = stmnt.executeQuery();
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

    public static void equipmentByType() {

    }

}