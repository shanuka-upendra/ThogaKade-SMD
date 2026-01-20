package controller.item;

import controller.model.ItemDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemFormController implements Initializable {

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
    private TableView<ItemDto> tblItems;

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

    ItemService itemService = new ItemInfoFormController();

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPackSize.setCellValueFactory(new PropertyValueFactory<>("packSize"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        loadItemTable();


    }

    void loadItemTable(){
        tblItems.setItems(itemService.getAllItems());
    }
}
