import java.util.Scanner;
import java.util.ArrayList;

public class Database{
    public static void main(String[] args) {

        ArrayList<Drone> drones = new ArrayList<Drone>();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        ArrayList<Equipment> equipment = new ArrayList<Equipment>();
        ArrayList<Member> members = new ArrayList<Member>();
        ArrayList<Order> orders = new ArrayList<Order>();
        ArrayList<Warehouse> warehouses = new ArrayList<Warehouse>();


        Scanner in = new Scanner(System.in);
        System.out.println("Hello, welcome to Drone Delivery Services.");
        
        while(true){
            System.out.println("Please enter data to store ('Q' to quit)");
            String input = in.nextLine();

            if(input.equals("Q")){
                break;
            }
        }

        in.close();
    }
}
