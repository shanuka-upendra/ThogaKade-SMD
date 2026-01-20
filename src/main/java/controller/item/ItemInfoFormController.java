package controller.item;

import controller.db.DBConnection;
import controller.model.ItemDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ItemInfoFormController implements ItemService{
    @Override
    public void addItem(String code, String desc, String size, Double price, Integer qty) {


    }

    @Override
    public void updateItem(String desc, String size, Double price, Integer qty, String code) {

    }

    @Override
    public void deleteItem(String code) {

    }

    @Override
    public ItemDto searchItem(String code) {
        return null;
    }

    @Override
    public ObservableList<ItemDto> getAllItems() {

        ObservableList<ItemDto> itemDtoList = FXCollections.observableArrayList();

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM item");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                ItemDto itemDto = new ItemDto(
                        resultSet.getString("ItemCode"),
                        resultSet.getString("Description"),
                        resultSet.getString("PackSize"),
                        resultSet.getDouble("UnitPrice"),
                        resultSet.getInt("QtyOnHand")
                );
                itemDtoList.add(itemDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemDtoList;
    }
}
