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

}

