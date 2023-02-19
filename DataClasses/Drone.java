public class Drone {
    
    String name;
    String weightCapacity;
    String year;
    String maxSpeed;
    String volumeCapacity;
    String distaceAutonomy;
    String manufacturer;
    Boolean status;
    String warrantyExpirationDate;
    String modelNumber;
    String serialNumber;
    String fleetID;
    
    public Drone(String _name, String _weightCapacity, String _year, String _maxSpeed, String _volumeCapacity, String _distaceAutonomy, String _manufacturer, Boolean _status, String _warrantyExpirationDate, String _modelNumber, String _serialNumber, String _fleetID){
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