public class Equipment {
    
    String type;
    int weight;
    int year;
    int size;
    String description;
    String arrivalDate;
    String modelNumber;
    String serialNumber;
    int inventoryID;    
    String manufacturer;
    String warrantyExp;

    
    public Equipment(String _type, String _city, int _year, int _size, String _description, String _arrivalDate, String _modelNumber, String _serialNumber, int _inventoryID, String _manufacturer, String _warrantyExp){
        this.type = _type;
        this.weight = _city;
        this.year = _year;
        this.size = _size;
        this.description = _description;
        this.arrivalDate = _arrivalDate;
        this.modelNumber = _modelNumber;
        this.serialNumber = _serialNumber;
        this.inventoryID = _inventoryID;
        this.manufacturer = _manufacturer;
        this.warrantyExp = _warrantyExp;
    }

}