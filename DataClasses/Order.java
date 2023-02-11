public class Order {
    
    String description;
    String estimatedDOA;
    String elementType;
    int orderNumber;
    int value;
    int numberOrdered;
    
    public Order(String _description, String _estimatedDOA, String _elementType, int _orderNumber, int _value, int _numberOrdered){
        this.description = _description;
        this.estimatedDOA = _estimatedDOA;
        this.elementType = _elementType;
        this.orderNumber = _orderNumber;
        this.value = _value;
        this.numberOrdered = _numberOrdered;
    }

}