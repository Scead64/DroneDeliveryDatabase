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

}