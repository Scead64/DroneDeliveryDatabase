public class Order {
    
    String description;
    String estimatedDOA;
    String elementType;
    String orderNumber;
    String value;
    String numberOrdered;
    
    public Order(String _description, String _estimatedDOA, String _elementType, String _orderNumber, String _value, String _numberOrdered){
        this.description = _description;
        this.estimatedDOA = _estimatedDOA;
        this.elementType = _elementType;
        this.orderNumber = _orderNumber;
        this.value = _value;
        this.numberOrdered = _numberOrdered;
    }

}