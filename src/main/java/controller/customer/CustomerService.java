package controller.customer;

import controller.model.CustomerDto;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.Date;

public interface CustomerService {
    void addCustomer(String id, String title, String name, LocalDate DOB, Double salary, String address, String city, String province, String postalCode);
    void updateCustomer(String id, String title, String name, LocalDate DOB,Double salary,String address,String city,String province,String postalCode);
    ObservableList<CustomerDto> getAllCustomers();
    void deleteCustomer(String id);
    CustomerDto searchCustomer(Integer id);
}
