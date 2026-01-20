package controller.item;

import controller.db.DBConnection;
import controller.model.ItemDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ItemInfoFormController implements ItemService{
    @Override
    public void addItem(String code, String desc, String size, Double price, Integer qty) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO item VALUES(?,?,?,?,?)");

            preparedStatement.setObject(1,code);
            preparedStatement.setObject(2,desc);
            preparedStatement.setObject(3,size);
            preparedStatement.setObject(4,price);
            preparedStatement.setObject(5,qty);

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void updateItem(String desc, String size, Double price, Integer qty, String code) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE item SET Description = ? , PackSize = ? , UnitPrice = ? , QtyOnHand = ? WHERE ItemCode = ?");

            preparedStatement.setObject(1,desc);
            preparedStatement.setObject(2,size);
            preparedStatement.setObject(3,price);
            preparedStatement.setObject(4,qty);
            preparedStatement.setObject(5,code);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteItem(String code) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM item WHERE ItemCode = ?");

            preparedStatement.setObject(1,code);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
