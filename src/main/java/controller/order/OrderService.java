package controller.order;

import controller.model.ItemDto;
import controller.model.OrderDto;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public interface OrderService {
    void addOrder(String id, LocalDate date,String customerId);
    void updateOrder(LocalDate date,String customerId,String id);
    void deleteOrder(String id);
    OrderDto searchOrderById(String id);
    ObservableList<OrderDto> getAllOrders();

}
