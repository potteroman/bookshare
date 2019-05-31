package bookshare.api.repositories.impl;

import bookshare.api.ConnectionManager;
import bookshare.api.entities.OrderEntity;
import bookshare.api.models.ClientOrderResponse;
import bookshare.api.repositories.OrderRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository

public class OrderRepositoryImpl implements OrderRepository {

    private static final String SELECT_ALL = "SELECT " +
            "\"user_id\"," +"\"user_id\"," +
            "\"announce_id\"," +
            "\"comment\"," +
            "\"is_active\"" +
            " FROM public.order o";


    private static final String CREATE =
            "INSERT INTO public.order (\"user_id\", \"announce_id\",\"comment\",\"is_active\") VALUES(?,?,?,?) RETURNING \"user_id\"";

    private static final String FIND_BY_CLIENT_ID = SELECT_ALL + " WHERE   o.user_id=? ";
    private static final String FIND_BY_ANNOUNCE_ID =  "SELECT " +
            "\"user_id\"," +
            "\"first_name\", " +
            "\"last_name\"," +
            "\"announce_id\"," +
            "\"comment\"" +
            " FROM public.order o JOIN public.user u ON o.user_id=u.id WHERE  o.announce_id=?  ";

    private static final String UPDATE_STATUS = "UPDATE public.order  SET \"is_active\" =? WHERE user_id = ? AND announce_id=?";

    @Override
    public List<OrderEntity> selectAll() throws SQLException {
        List<OrderEntity> entities = new ArrayList<>();
        try (
                Connection connection = ConnectionManager.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_ALL)
        ) {
            while (resultSet.next()) {
                entities.add(parseResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }


    @Override
    public OrderEntity insert(OrderEntity entity) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE)) {
            setPreparedStatementData(statement, entity);
            try (ResultSet generatedKeys = statement.executeQuery()) {
                if (generatedKeys.next()) {
                    entity.setUserId(generatedKeys.getInt(1));

                }
            }
        }
        return entity;
    }

    @Override
    public OrderEntity findById(Integer id) throws SQLException {
        return null;
    }

    public  OrderEntity findByClientId(Integer _id) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_CLIENT_ID)) {
            statement.setInt(1, _id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return parseResultSet(resultSet);
            }

        }
        return null;

    }
    public  List<ClientOrderResponse> findByAnnounceId(Integer _id) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ANNOUNCE_ID)) {
            List<ClientOrderResponse> clientOrderResponses = new ArrayList<>();
            statement.setInt(1, _id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer userId = resultSet.getInt("user_id");

                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Integer announceId = resultSet.getInt("announce_id");
                String comment = resultSet.getString("comment");

                clientOrderResponses.add(new ClientOrderResponse(userId,firstName,lastName,announceId,comment));

            }
            return clientOrderResponses;
        }
    }

    public int updateStatus(OrderEntity entity) throws SQLException {  //TODO
        int updatesNumber = 0;
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_STATUS)) {
            statement.setBoolean(1,entity.getActive());
            statement.setInt(2,entity.getUserId());
            statement.setInt(3,entity.getAnnounceId());
            updatesNumber = statement.executeUpdate();
        }
        return updatesNumber;

    }

    public int update(OrderEntity entity) throws SQLException {
        return 0;
    }


    public int delete(OrderEntity entity) throws SQLException {
        return 0;
    }

    private OrderEntity parseResultSet(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("user_id");
        Integer announceId = resultSet.getInt("announce_id");
        String comment = resultSet.getString("comment");
        Boolean isActive = resultSet.getBoolean("is_active");
        return new OrderEntity(id, announceId, comment, isActive);
    }

    private void setPreparedStatementData(PreparedStatement statement, OrderEntity entity) throws SQLException {
        statement.setInt(1,entity.getUserId());
        statement.setInt(2, entity.getAnnounceId());
        statement.setString(3, entity.getComment());
        statement.setBoolean(4, entity.getActive());
    }

    public static void main(String[] args) throws SQLException {

        new OrderRepositoryImpl().selectAll().forEach(System.out::println);
        new OrderRepositoryImpl().updateStatus(new OrderEntity(1,1,"sdsd",true));
        new OrderRepositoryImpl().selectAll().forEach(System.out::println);

    }
}
