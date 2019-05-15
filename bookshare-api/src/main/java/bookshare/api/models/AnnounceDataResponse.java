package bookshare.api.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnnounceDataResponse {
    private Integer id;
    private String first_name;

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    private String last_name;
    private String bookName;
    private String bookGenre;
    private String author;
    private LocalDate year;
    private LocalDateTime announceTimestamp;

    public AnnounceDataResponse(Integer id, String first_name, String last_name, String bookName, String bookGenre, String author, LocalDate year, LocalDateTime announceTimestamp) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.bookName = bookName;
        this.bookGenre = bookGenre;
        this.author = author;
        this.year = year;
        this.announceTimestamp = announceTimestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public LocalDateTime getAnnounceTimestamp() {
        return announceTimestamp;
    }

    public void setAnnounceTimestamp(LocalDateTime announceTimestamp) {
        this.announceTimestamp = announceTimestamp;
    }
}