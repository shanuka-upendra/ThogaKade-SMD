package controller.customer;

import controller.model.CustomerDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class CustomerInfoController implements CustomerService{


    @Override
    public void addCustomer() {

    }

    @Override
    public void updateCustomer() {

    }

    @Override
    public void deleteCustomer() {

    }

    @Override
    public ObservableList<CustomerDto> getAllCustomers() {
        ObservableList<CustomerDto> customerInfoDto = FXCollections.observableArrayList();
        return customerInfoDto;
    }

    @Override
    public CustomerDto searchCustomer() {
        return null;
    }
}
