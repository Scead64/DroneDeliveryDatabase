

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UsefulReports {

    public static void rentingCheckouts(Connection conn, int user) {
        // Renting checkouts: Find the total number of equipment items rented by a single member patron (user designates the member) (see query from Checkpoint #3)
        /*
         * SELECT user_id, COUNT(serial_number) AS total_items_rented FROM
         * Equipment_Rental WHERE user_id = ?;
         */

        String query = "SELECT user_id, COUNT(serial_number) AS total_items_rented FROM Equipment_Rental WHERE user_id = ?;";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, user);
            ResultSet rSet = stmt.executeQuery();
            while (rSet.next()) {
                int user_id = rSet.getInt("user_id");
                int total_items_rented = rSet.getInt("total_items_rented");
                System.out.println("User ID: " + user_id
                        + " Total Items Rented: " + total_items_rented);

            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void popularItem(Connection conn) {
        //Popular item: find the most popular item in the database

        // SELECT Equipment.serial_number, COUNT(Equipment_Rental.serial_number) as num_rented
        // FROM Equipment, Equipment_Rental
        // WHERE Equipment.serial_number = Equipment_Rental.serial_number
        // GROUP BY Equipment_Rental.serial_number
        // ORDER BY num_rented DESC LIMIT 5;

        String query = "SELECT Equipment.serial_number, COUNT(Equipment_Rental.serial_number) as num_rented , Equipment.department, Equipment.description FROM Equipment, Equipment_Rental WHERE Equipment.serial_number = Equipment_Rental.serial_number GROUP BY Equipment_Rental.serial_number ORDER BY num_rented DESC LIMIT 1;";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rSet = stmt.executeQuery();
            while (rSet.next()) {
                String serial_number = rSet.getString("serial_number");
                int num_rented = rSet.getInt("num_rented");
                String department = rSet.getString("department");
                String description = rSet.getString("description");
                System.out.println("\n");
                System.out.println("The most popular item is " + serial_number
                        + " in the " + department
                        + " department. \nDescription: " + description);
                System.out.println(
                        "This item was rented " + num_rented + " times.");
                System.out.println("\n");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void popularManufacturer(Connection conn) {

        // Popular Manufacturer: Find the most frequent equipment manufacturer in the database (i.e. the one who has had the most rented units)

        // SELECT manufacturer, MAX(rented) AS rented
        // FROM (SELECT manufacturer, COUNT(Equipment_rental.user_id) AS rented
        // FROM Equipment, Equipment_Info, Equipment_Rental
        // WHERE Equipment.serial_number = Equipment_Rental.serial_number
        // AND Equipment.model_number = Equipment_Info.model_number
        // GROUP BY Equipment_info.manufacturer);

        String query = "SELECT manufacturer, MAX(rented) AS rented FROM (SELECT manufacturer, COUNT(Equipment_rental.user_id) AS rented FROM Equipment, Equipment_Info, Equipment_Rental WHERE Equipment.serial_number = Equipment_Rental.serial_number AND Equipment.model_number = Equipment_Info.model_number GROUP BY Equipment_info.manufacturer);";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rSet = stmt.executeQuery();
            while (rSet.next()) {
                String manufacturer = rSet.getString("manufacturer");
                String rented = rSet.getString("rented");
                System.out.println("\n");
                System.out.println(
                        "The manufacturer with the most rented items is "
                                + manufacturer + ".");
                System.out.println("An item from this manufacturer was rented "
                        + rented + " times.");
                System.out.println("\n");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void popularDrone(Connection conn) {
        /*
         * Find the most used drone in the database (use the flying distance of
         * the drone -member distance- and number of deliveries the drone has
         * been traveled to calculate) (see similar query from Checkpoint #4)
         */

        String query = "SELECT Equipment_Delivery.drone_serial_num, COUNT(Equipment_Delivery.equipment_serial_number) AS num_delivered\r\n"
                + "FROM Equipment_Delivery\r\n"
                + "GROUP BY Equipment_Delivery.drone_serial_num\r\n"
                + "ORDER BY num_delivered DESC\r\n" + "Limit 1;";
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

    public static void equipmentByType(Connection conn, String type,
            String year) {
        String query = "SELECT description\r\n"
                + "FROM Equipment, Equipment_Info\r\n"
                + "WHERE Equipment_Info.type = ?\r\n"
                + "    AND Equipment.model_number = Equipment_Info.model_number\r\n"
                + "AND year < ?;";
        try {
            PreparedStatement stmnt = conn.prepareStatement(query);

            stmnt.setString(1, type);

            LocalDateTime datetimeParam = LocalDateTime.parse(
                    year + "-01-01T00:00:00",
                    DateTimeFormatter.ISO_LOCAL_DATE_TIME); // Query parameter
            stmnt.setString(2, datetimeParam.format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            ResultSet rs = stmnt.executeQuery();

            System.out.println("\n");
            System.out.println("Type: " + type);
            while (rs.next()) {
                System.out
                        .println("Description: " + rs.getString("description"));
                System.out.println("\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}