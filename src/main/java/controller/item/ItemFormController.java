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
        String code = txtItemCode.getText();
        String desc = txtDesc.getText();
        String packSize = txtPackSize.getText();
        Double price = Double.valueOf(txtUnitPrice.getText());
        Integer qty = Integer.valueOf(txtQty.getText());

        itemService.addItem(code,desc,packSize,price,qty);
        loadItemTable();
    }

    @FXML
    void btnSearchItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteItemOnAction(ActionEvent event) {
        itemService.deleteItem(txtItemCode.getText());
        loadItemTable();

    }

    @FXML
    void btnUpdateItemOnAction(ActionEvent event) {
        String code = txtItemCode.getText();
        String desc = txtDesc.getText();
        String packSize = txtPackSize.getText();
        Double price = Double.valueOf(txtUnitPrice.getText());
        Integer qty = Integer.valueOf(txtQty.getText());

        itemService.updateItem(desc,packSize,price,qty,code);
        loadItemTable();

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
