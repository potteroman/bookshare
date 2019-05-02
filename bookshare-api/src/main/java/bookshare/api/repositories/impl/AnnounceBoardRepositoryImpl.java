package bookshare.api.repositories.impl;

import bookshare.api.ConnectionManager;
import bookshare.api.entities.AnnounceBoardEntity;
import bookshare.api.repositories.AnnounceBoardRepository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class AnnounceBoardRepositoryImpl implements AnnounceBoardRepository {

    private static final String INSERT_Book_SQL = "INSERT INTO \"announce_board\" (id,user_id,book_id,announce_timestamp) VALUES (?, ?, ?, ?) RETURNING id";

    public AnnounceBoardEntity insert(AnnounceBoardEntity announceBoard) throws SQLException {
        Connection dbConnection = ConnectionManager.getConnection();

        try (PreparedStatement statement = dbConnection.prepareStatement(INSERT_Book_SQL)) {
            statement.setInt(1, announceBoard.getId());
            statement.setInt(2, announceBoard.getUserId());
            statement.setInt(3,announceBoard.getBookId());
            statement.setTimestamp(4, Timestamp.valueOf(announceBoard.getAnnounceTimestamp()));

            try (ResultSet generatedKeys = statement.executeQuery()) {
                if (generatedKeys.next()) {
                    announceBoard.setId(generatedKeys.getInt(1));
                }
            }
        }
        return announceBoard;
    }

    public static void main(String[] args) throws Exception {
        new AnnounceBoardRepositoryImpl().insert(new AnnounceBoardEntity(1,1,1,LocalDateTime.now()));
    }
}
