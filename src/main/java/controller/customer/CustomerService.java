package controller.customer;

import controller.model.CustomerDto;
import javafx.collections.ObservableList;

import java.util.List;

public interface CustomerService {
    void addCustomer();
    void updateCustomer();
    void deleteCustomer();
    ObservableList<CustomerDto> getAllCustomers();
    CustomerDto searchCustomer();
}
