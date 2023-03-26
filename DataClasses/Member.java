package DataClasses;
import java.util.ArrayList;
import java.util.Scanner;

public class Member extends Person {
    
    public String startDate;
    public ArrayList<Review> reviews;

    public Member(int _userID, String _fname, String _lname, String _address, String _email, String _password, String _phone, String _startDate){
        this.fname = _fname;
        this.lname = _lname;
        this.address = _address;
        this.email = _email;
        this.password = _password;
        this.phone = _phone;
        this.userID = _userID;
        this.startDate = _startDate;
        this.reviews = new ArrayList<Review>();
    }

    public void display(){
        System.out.println("UserID: " + this.userID);
        System.out.println("Fname: " + this.fname);
        System.out.println("Lname: " + this.lname);
        System.out.println("Address: " + this.address);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Phone: " + this.phone);
        System.out.println("Start Date: " + this.startDate);
        System.out.println();
    }

    public void edit(Scanner in){
        String input, data;
        while(true){
            System.out.print("Enter field to edit: ");
            input = in.nextLine();
            System.out.println("Enter new data: ");
            data = in.nextLine();

            if(input.equalsIgnoreCase("fname")){
                this.fname = data;
            } else if(input.equalsIgnoreCase("lname")){
                this.lname = data;
            } else if(input.equalsIgnoreCase("address")){
                this.address = data;
            } else if(input.equalsIgnoreCase("email")){
                this.email = data;
            } else if(input.equalsIgnoreCase("password")){
                this.password = data;
            } else if(input.equalsIgnoreCase("phone")){          
                this.phone = data;
            } else if(input.equalsIgnoreCase("start date")){      
                this.startDate = data;
            } else {
                System.out.println("Error: invalid attribute");
            }

            System.out.print("Enter 'C' to continue editing ");
            input = in.nextLine();
            if(!input.equalsIgnoreCase("C")){
                break;
            }
        }
    }
}

