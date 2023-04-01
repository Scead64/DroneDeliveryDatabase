import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class QueryManager {

    /*
     * Displays all data currently in the table
     */
    public static void display(Connection conn, String query) {
        try {
            //Query data
            PreparedStatement stmt = conn.prepareStatement(query);
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
    }
    
    /*
     * @returns true if the query gets a row and prints it, false otherwise
     */
    public static Boolean select(Scanner in, Connection conn, String table, String query, String key) {
        Boolean inTable = true;
        try {
            //Query data
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + table + query);
            stmt.setString(1, key);
            ResultSet rSet = stmt.executeQuery();
            ResultSetMetaData rsmd = rSet.getMetaData();
            int columnCount = rsmd.getColumnCount();

            if(rSet.next() != false){
                //Print data
                System.out.println("\nData:");
                do {
                    for (int i = 1; i <= columnCount; i++) {
                        String columnValue = rSet.getString(i);
                        System.out.print(columnValue);
                        if (i < columnCount) {
                            System.out.print(",  ");
                        }
                    }
                    System.out.print("\n");
                } while (rSet.next());

                String input;
                while(true){
                    System.out.println("\tEdit: Change row"
                                    + "\n\tDelete: Delete row"
                                    + "\n\tBack: Return to table submenu");
                    input = in.nextLine();

                    if(input.equalsIgnoreCase("Edit")){
                        String value;
                        System.out.print("Enter field to edit: ");
                        input = in.nextLine();
                        System.out.print("Enter new value: ");
                        value = in.nextLine();

                        stmt = conn.prepareStatement("UPDATE " + table + " SET " + input + " = ?");
                        stmt.setString(1, value);
                        stmt.executeUpdate();

                    } else if(input.equalsIgnoreCase("Delete")){
                        stmt = conn.prepareStatement("DELETE FROM " + table + query);
                        stmt.setString(1, key);
                        stmt.executeUpdate();
                        break;

                    } else if(input.equalsIgnoreCase("Back")){
                        break;
                        
                    } else {
                            System.out.println("Error: invalid input");
                    }
                }

            } else {
                inTable = false;
            }
            
            //Close opened resources
            rSet.close();
            stmt.close();

        //Catch any SQL exception and print message
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();
        return inTable;
    }
}