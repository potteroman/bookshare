package bookshare.api.entities;

import java.time.LocalDate;

public class BookEntity {
    private Long id;
    private String name;
    private String author;
    private String genre;
    private LocalDate year;
    private String discription;

    public BookEntity(Long id, String name, String author, String genre, LocalDate year, String discription) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.discription = discription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
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
}