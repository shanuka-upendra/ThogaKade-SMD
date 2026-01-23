package controller.order.placeorder;

public interface PlaceOrderService {
    void placeOrder(String id,String name,String code,String description,Double unitPrice, Integer qty);
    void addToCart(String id,String name,String code,String description,Double unitPrice, Integer qty);
}
