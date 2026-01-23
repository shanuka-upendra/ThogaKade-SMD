package controller.order.placeorder;

import controller.db.DBConnection;
import controller.model.CustomerDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    void btnAddToCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

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

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> items = FXCollections.observableArrayList();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ItemCode,Description,UnitPrice FROM item");

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                items.add(resultSet.getString("ItemCode") +" "+ resultSet.getString("Description"));
            }
            cmbItems.setItems(items);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void cmbMouseOnPressed(MouseEvent mouseEvent) {

    }
}


