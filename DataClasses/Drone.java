public class Drone {
    
    String name;
    int weightCapacity;
    int year;
    int maxSpeed;
    int volumeCapacity;
    int distaceAutonomy;
    String manufacturer;
    Boolean status;
    String warrantyExpirationDate;
    String modelNumber;
    String serialNumber;
    int fleetID;
    
    public Drone(String _name, int _weightCapacity, int _year, int _maxSpeed, int _volumeCapacity, int _distaceAutonomy, String _manufacturer, Boolean _status, String _warrantyExpirationDate, String _modelNumber, String _serialNumber, int _fleetID){
        this.name = _name;
        this.weightCapacity = _weightCapacity;
        this.year = _year;
        this.maxSpeed = _maxSpeed;
        this.volumeCapacity = _volumeCapacity;
        this.distaceAutonomy = _distaceAutonomy;
        this.manufacturer = _manufacturer;
        this.status = _status;
        this.warrantyExpirationDate = _warrantyExpirationDate;
        this.modelNumber = _modelNumber;
        this.serialNumber = _serialNumber;
        this.fleetID = _fleetID;
    }

}