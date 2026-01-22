package controller.order;

import controller.model.OrderDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class OrderFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> colCustomerID;

    @FXML
    private TableColumn<?, ?> colOrderDate;

    @FXML
    private TableColumn<?, ?> colOrderID;

    @FXML
    private TextField txtCustomerID;

    @FXML
    private DatePicker txtOrderDate;

    @FXML
    private TextField txtOrderID;

    @FXML
    private TableView<OrderDto> tblOrders;

    OrderService orderService = new OrderInfoFormController();

    @FXML
    void btnAddOrderOnAction(ActionEvent event) {
        String orderId = txtOrderID.getText();
        LocalDate orderDate = txtOrderDate.getValue();
        String customerId = txtCustomerID.getText();

        orderService.addOrder(orderId,orderDate,customerId);
        loadOrderTable();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        orderService.deleteOrder(txtOrderID.getText());
        loadOrderTable();
    }

    @FXML
    void btnSearchOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOrderOnAction(ActionEvent event) {
        String orderId = txtOrderID.getText();
        LocalDate orderDate = txtOrderDate.getValue();
        String customerId = txtCustomerID.getText();

        orderService.updateOrder(orderDate,customerId,orderId);
        loadOrderTable();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colOrderID.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colOrderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerId"));

        loadOrderTable();

    }

    void loadOrderTable(){
        tblOrders.setItems(orderService.getAllOrders());
    }
}
