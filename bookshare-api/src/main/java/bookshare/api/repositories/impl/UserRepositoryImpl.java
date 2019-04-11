package bookshare.api.repositories.impl;

import bookshare.api.entities.User;
import bookshare.api.repositories.UserRepository;

import java.sql.*;

public class UserRepositoryImpl implements UserRepository {

    private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/bookshare_db";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "123456";

    private static final String INSERT_USER_SQL = "INSERT INTO \"user\" (username, email, password, firstName, lastName, city, phone, isActive) VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING id";

    public User insert(User user) throws Exception {
        try (Connection dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD)) {
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
                        user.setId(generatedKeys.getLong(1));
                    }
                }
            }
            return user;
        }
    }

}