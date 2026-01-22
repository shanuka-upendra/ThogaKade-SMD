package controller.order;

import controller.db.DBConnection;
import controller.model.OrderDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class OrderInfoFormController implements OrderService{
    @Override
    public void addOrder(String id, LocalDate date, String customerId) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders VALUES (?,?,?)");

            preparedStatement.setObject(1,id);
            preparedStatement.setObject(2,date);
            preparedStatement.setObject(3,customerId);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateOrder(LocalDate date, String customerId, String id) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE orders SET OrderDate = ? , CustID = ? WHERE OrderID = ?");

            preparedStatement.setObject(1,date);
            preparedStatement.setObject(2,customerId);
            preparedStatement.setObject(3,id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteOrder(String id) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM orders WHERE OrderID = ?");

            preparedStatement.setObject(1,id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public OrderDto searchOrderById(String id) {
        try {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders");
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()) {
            return new OrderDto(
                    resultSet.getString("OrderID"),
                    resultSet.getDate("OrderDate"),
                    resultSet.getString("CustID")
            );
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
        return null;
    }

    @Override
    public ObservableList<OrderDto> getAllOrders() {
        ObservableList<OrderDto> orderDtoList = FXCollections.observableArrayList();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                OrderDto orderDto = new OrderDto(
                        resultSet.getString("OrderID"),
                        resultSet.getDate("OrderDate"),
                        resultSet.getString("CustID")
                );
                orderDtoList.add(orderDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDtoList;
    }
}
