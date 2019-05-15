package bookshare.api.repositories.impl;

import bookshare.api.ConnectionManager;
import bookshare.api.entities.AnnounceBoardEntity;
import bookshare.api.models.AnnounceDataResponse;
import bookshare.api.repositories.AnnounceBoardRepository;
import bookshare.api.models.AnnounceDataResponse;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class AnnounceBoardRepositoryImpl implements AnnounceBoardRepository {

    private static final String INSERT_Book_SQL = "INSERT INTO \"announce_board\" (id,user_id,book_id,announce_timestamp) VALUES (?, ?, ?, ?) RETURNING id";
    private static final String SELECT_ALL = "SELECT * FROM public.announce_board";
    private static final String SELECT_ALL2 = "SELECT a.id, u.last_name, b.name, a.announce_timestamp FROM public.announce_board a JOIN public.\"user\" u ON  a.user_id=u.id JOIN  public.\"book\" b ON a.book_id = b.id";

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


    public List<AnnounceBoardEntity> selectAll() throws SQLException {
        List<AnnounceBoardEntity> entities = new ArrayList<>();
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

    private AnnounceDataResponse parseResultSet2(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String user = resultSet.getString("last_name");
        String book = resultSet.getString("name");
        LocalDateTime announceTS = resultSet.getTimestamp("announce_timestamp").toLocalDateTime();
        return new AnnounceDataResponse(id,user,book, announceTS);
    }

    public List<AnnounceDataResponse> selectAll2() throws SQLException {
        List<AnnounceDataResponse> entities = new ArrayList<>();
        try (
                Connection connection = ConnectionManager.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_ALL2)
        ) {
            while (resultSet.next()) {
                entities.add(parseResultSet2(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }



    private AnnounceBoardEntity parseResultSet(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        Integer userId = resultSet.getInt("user_id");
        Integer bookId = resultSet.getInt("book_id");
        LocalDateTime announceTS = resultSet.getTimestamp("announce_timestamp").toLocalDateTime();
        return new AnnounceBoardEntity(id, userId, bookId, announceTS);
    }


    public static void main(String[] args) throws Exception {
        //new AnnounceBoardRepositoryImpl().insert(new AnnounceBoardEntity(1,1,1,LocalDateTime.now()));
        new AnnounceBoardRepositoryImpl().insert(new AnnounceBoardEntity(2,1,1,LocalDateTime.now()));
        new AnnounceBoardRepositoryImpl().insert(new AnnounceBoardEntity(3,1,2,LocalDateTime.now()));
        new AnnounceBoardRepositoryImpl().insert(new AnnounceBoardEntity(4,1,3,LocalDateTime.now()));
        new AnnounceBoardRepositoryImpl().selectAll().forEach(System.out::println);
    }
}
