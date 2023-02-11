public class Warehouse {
    
    String address;
    String city;
    String phone;
    int droneCapacity;
    int storageCapacity;
    
    public Warehouse(String _address, String _city, String _phone, int _droneCapacity, int _storageCapacity){
        this.address = _address;
        this.city = _city;
        this.phone = _phone;
        this.droneCapacity = _droneCapacity;
        this.storageCapacity = _storageCapacity;
    }

}