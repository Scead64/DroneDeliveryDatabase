public class Emplyee extends Person {
    
    String employeeID;

    public Person(String _fname, String _lname, String _address, String _email, String _password, String _phone, String _employeeID){
        this.fname = _fname;
        this.lname = _lname;
        this.address = _address;
        this.email = _email;
        this.password = _password;
        this.phone = _phone;
        this.employeeID = _employeeID;
    }

}