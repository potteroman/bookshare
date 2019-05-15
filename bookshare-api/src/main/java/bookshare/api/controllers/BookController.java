package bookshare.api.controllers;

import bookshare.api.entities.BookEntity;
import bookshare.api.models.BookDataResponse;
import bookshare.api.repositories.BookRepository;
import bookshare.api.repositories.impl.BookRepositoryImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin

public class BookController {
    private final BookRepository BookRepository;


    public BookController() {
        this.BookRepository = new BookRepositoryImpl();
    }



//    @PostMapping("/api/bookannounce/add")
//    public AnnounceAddResponse posting(@RequestBody AnnounceAddRequest addRequest) throws Exception {
//
//        BookEntity newBook = new BookEntity();
//        newBook.setId(addRequest.getId());
//        newBook.setName(addRequest.getName());
//        newAnnounce.setBookId(addRequest.getBookId());
//        newAnnounce.setAnnounceTimestamp(addRequest.getAnnounceTimestamp());
//
//        AnnounceBoardEntity insertedAnnounce = this.announceBoardRepository.insert(newAnnounce);
//
//        AnnounceAddResponse annonceResponse = new AnnounceAddResponse();
//        annonceResponse.setId(insertedAnnounce.getId());
//
//        return annonceResponse;
//    }

    @GetMapping(value = "/api/book")  //return data set of books
    public List<BookDataResponse> getAllUsers() throws Exception {
        List<BookEntity> bookEntities = BookRepository.selectAll();
        List<BookDataResponse> bookDataResponses=new ArrayList<>();
        bookEntities.forEach((e)->{
            bookDataResponses.add(new BookDataResponse(e.getName(),e.getAuthor(),e.getGenre(),e.getYear(),e.getDescription()));
        });
        return bookDataResponses;
    }

}
