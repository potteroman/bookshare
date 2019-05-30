package bookshare.api.repositories.impl;

import bookshare.api.ConnectionManager;
import bookshare.api.entities.UserEntity;
import bookshare.api.repositories.UserRepository;

import java.sql.*;

public class UserRepositoryImpl implements UserRepository {

    private static final String INSERT_USER_SQL = "INSERT INTO \"user\" (username, email, password, first_name, last_name, city, phone, is_active) VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING id";

    Connection dbConnection = ConnectionManager.getConnection();

    public UserEntity insert(UserEntity user) throws Exception {
            try (PreparedStatement statement = dbConnection.prepareStatement(INSERT_USER_SQL)) {
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getPassword());
                statement.setString(4, user.getFirstName());
                statement.setString(5, user.getLastName());
                statement.setString(6, user.getCity());
                statement.setString(7, user.getPhone());
                statement.setBoolean(8, user.isActive());

                try (ResultSet generatedKeys = statement.executeQuery()) {
                    if (generatedKeys.next()) {
                        user.setId(generatedKeys.getInt(1));
                    }
                }
            }
            return user;

    }

}