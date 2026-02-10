package controller.order.placeorder;

import controller.db.DBConnection;
import controller.model.CustomerDto;
import controller.model.ItemDto;
import controller.model.OrderDetailDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;

public class PlaceOrderFormContoller implements Initializable {

    @FXML
    private ComboBox<String> cmbItems;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colDiscount;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private Label lblNetTotal;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtCustomerName;


    @FXML
    private TextField txtDiscount;


    @FXML
    private TextField txtQunatity;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    private TableView<OrderDetailDto> tblPlaceOrder;

    private Double total = 0.0;

    ObservableList<OrderDetailDto> orderDetailDtos = FXCollections.observableArrayList();

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        OrderDetailDto detailDto = new OrderDetailDto(
                getOrderId(),
                cmbItems.getValue(),
                Integer.parseInt(txtQunatity.getText()),
                Double.parseDouble(txtUnitPrice.getText()),
                Integer.parseInt(txtDiscount.getText()),
                getTotal()

        );

        orderDetailDtos.add(detailDto);

    }

    Double getTotal(){
        Double total = ((Double.parseDouble(txtUnitPrice.getText()) * Integer.parseInt(txtQunatity.getText())));
        Double dis = total*Double.parseDouble(txtDiscount.getText())/100;
        this.total+= total - dis;
        lblNetTotal.setText(this.total+"");
        return total - dis ;
    }

    String getOrderId(){
        return "I001";
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    HashMap<String,ItemDto> hashMap = new HashMap<>();

    @FXML
    void txtCustomerIdOnKeyPressed(KeyEvent event) {
        try {
            CustomerDto customerDto = new CustomerDto();
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT CustID,CustName From customer WHERE CustID = ?");

            preparedStatement.setObject(1,txtCustomerId.getText());

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                 customerDto.setId(resultSet.getString("CustID"));
                 customerDto.setName(resultSet.getString("CustName"));
            }
            txtCustomerName.setText(customerDto.getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tblPlaceOrder.setItems(orderDetailDtos);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("code"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        lblNetTotal.setText(total+"");

        ObservableList<String> items = FXCollections.observableArrayList();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ItemCode,Description,UnitPrice FROM item");

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                ItemDto itemDto = new ItemDto();
                itemDto.setItemCode(resultSet.getString("ItemCode"));
                itemDto.setDescription(resultSet.getString("Description"));
                itemDto.setPrice(resultSet.getDouble("UnitPrice"));
                items.add(resultSet.getString("ItemCode") +" "+ resultSet.getString("Description"));
                hashMap.put(resultSet.getString("ItemCode") +" "+ resultSet.getString("Description"),itemDto);
            }
            cmbItems.setItems(items);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void cmbItemsOnAction(ActionEvent actionEvent) {
        txtUnitPrice.setText(hashMap.get(cmbItems.getValue()).getPrice()+"");
    }
}


