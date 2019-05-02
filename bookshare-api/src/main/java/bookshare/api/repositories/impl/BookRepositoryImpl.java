package bookshare.api.repositories.impl;

import bookshare.api.ConnectionManager;
import bookshare.api.entities.BookEntity;
import bookshare.api.repositories.BookRepository;
import java.sql.*;
import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;


public class BookRepositoryImpl implements BookRepository {

    private static final String INSERT_Book_SQL = "INSERT INTO \"book\" (name, autor, genre, year, description) VALUES (?, ?, ?, ?, ?) RETURNING id";

    public BookEntity insert(BookEntity book) throws Exception {

        Connection dbConnection = ConnectionManager.getConnection();

            try (PreparedStatement statement = dbConnection.prepareStatement(INSERT_Book_SQL)) {
                statement.setString(1, book.getName());
                statement.setString(2, book.getAuthor());
                statement.setString(3, book.getGenre());
                statement.setDate(4, Date.valueOf(book.getYear()));
                statement.setString(5, book.getDiscription());

                try (ResultSet generatedKeys = statement.executeQuery()) {
                    if (generatedKeys.next()) {
                        book.setId(generatedKeys.getLong(1));
                    }
                }
            }
            return book;
        }

    public static void main(String[] args) throws Exception {
        //new BookRepositoryImpl().insert(new BookEntity(0l,"The song of ice and fire","R. Martin","fantasy",
               // LocalDate.ofYearDay(2007,1),""));
        new BookRepositoryImpl().insert(new BookEntity(1l,"Harry Potter","J.K. Rowling","fantasy",
                LocalDate.ofYearDay(1997,1),""));
        new BookRepositoryImpl().insert(new BookEntity(2l,"Sherlock Holmes"," Sir Arthur Conan Doyle","Detective",
                LocalDate.ofYearDay(1887,1),""));
        new BookRepositoryImpl().insert(new BookEntity(3l,"Lord of the rings","J. R. R. Tolkien","fantasy",
                LocalDate.ofYearDay(1949,1),""));

    }
}
