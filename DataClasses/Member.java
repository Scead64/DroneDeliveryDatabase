import java.util.Scanner;

public class Member extends Person {
    
    String startDate;

    public Member(int _userID, String _fname, String _lname, String _address, String _email, String _password, String _phone, String _startDate){
        this.fname = _fname;
        this.lname = _lname;
        this.address = _address;
        this.email = _email;
        this.password = _password;
        this.phone = _phone;
        this.userID = _userID;
        this.startDate = _startDate;
    }

    public void display(){
        System.out.print("UserID: " + this.userID + " ");
        System.out.print("Fname: " + this.fname + " ");
        System.out.print("Lname: " + this.lname + " ");
        System.out.print("Address: " + this.address + " ");
        System.out.print("Email: " + this.email + " ");
        System.out.print("Password: " + this.password + " ");
        System.out.print("Phone: " + this.phone + " ");
        System.out.println("Start Date: " + this.startDate);
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

