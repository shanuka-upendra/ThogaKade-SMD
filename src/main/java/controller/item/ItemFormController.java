package controller.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ItemFormController {

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colPackSize;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableView<?> tblItems;

    @FXML
    private TextField txtDesc;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtPackSize;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    void btnAddItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnClearItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateItemOnAction(ActionEvent event) {

    }

}
