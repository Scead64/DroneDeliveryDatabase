public class Equipment {
    
    String type;
    String weight;
    String year;
    String size;
    String description;
    String arrivalDate;
    String modelNumber;
    String serialNumber;
    String inventoryID;    
    String manufacturer;
    String warrantyExp;

    
    public Equipment(String _type, String _weight, String _year, String _size, String _description, String _arrivalDate, String _modelNumber, String _serialNumber, String _inventoryID, String _manufacturer, String _warrantyExp){
        this.type = _type;
        this.weight = _weight;
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