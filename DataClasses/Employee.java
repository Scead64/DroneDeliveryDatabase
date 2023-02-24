import java.util.Scanner;

public class Employee extends Person {
    
    String YOE;
    String salary;

    public Employee(int _userID, String _fname, String _lname, String _address, String _email, String _password, String _phone, String _YOE, String _salary){
        this.userID = _userID;
        this.fname = _fname;
        this.lname = _lname;
        this.address = _address;
        this.email = _email;
        this.password = _password;
        this.phone = _phone;
        this.YOE = _YOE;
        this.salary = _salary;
    }

    public void display(){
        System.out.print("UserID: " + this.userID + " ");
        System.out.print("Fname: " + this.fname + " ");
        System.out.print("Lnane: " + this.lname + " ");
        System.out.print("Address: " + this.address + " ");
        System.out.print("Email: " + this.email + " ");
        System.out.print("Password: " + this.password + " ");
        System.out.print("Phone: " + this.phone + " ");
        System.out.print("YOE: " + this.YOE + " ");
        System.out.println("Salary: " + this.salary);
    }

    public void edit(Scanner in){
        String input, data;
        while(true){
            System.out.print("Enter field to edit: ");
            input = in.nextLine();
            System.out.print("Enter new data: ");
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
            } else if(input.equalsIgnoreCase("YOE")){
                this.YOE = data;
            } else if(input.equalsIgnoreCase("salary")){
                this.salary = data;
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