package bookshare.api.controllers;

import bookshare.api.entities.*;

import bookshare.api.models.AnnounceAddRequest;
import bookshare.api.models.AnnounceAddResponse;
import bookshare.api.models.AnnounceDataResponse;

import bookshare.api.repositories.AnnounceBoardRepository;
import bookshare.api.repositories.UserAnnounceBookRepository;

import bookshare.api.repositories.impl.AnnounceBoardRepositoryImpl;
import bookshare.api.repositories.impl.UserAnnounceBookRepositoryImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin

public class AnnounceBoardController {
    private final AnnounceBoardRepository announceBoardRepository;
    private final UserAnnounceBookRepository userAnnounceBookRepository;

    public AnnounceBoardController() {
        this.userAnnounceBookRepository = new UserAnnounceBookRepositoryImpl();
        this.announceBoardRepository=new AnnounceBoardRepositoryImpl();
    }

    @PostMapping("/api/announce/add")
    public AnnounceAddResponse posting(@RequestBody AnnounceAddRequest addRequest) throws Exception {

        AnnounceBoardEntity newAnnounce = new AnnounceBoardEntity();
        newAnnounce.setId(addRequest.getId());
        newAnnounce.setUserId(addRequest.getUserId());
        newAnnounce.setBookId(addRequest.getBookId());
        newAnnounce.setAnnounceTimestamp(addRequest.getAnnounceTimestamp());

        AnnounceBoardEntity insertedAnnounce = this.announceBoardRepository.insert(newAnnounce);

        AnnounceAddResponse annonceResponse = new AnnounceAddResponse();
        annonceResponse.setId(insertedAnnounce.getId());

        return annonceResponse;
    }

    @GetMapping(value = "/api/announce")
    public ResponseEntity<List<AnnounceDataResponse>> getAllUsers() throws SQLException {
        List<UserAnnounceBookEntity> announceBoardEntities = userAnnounceBookRepository.selectAll();
        List<AnnounceDataResponse> announceDataResponses = new ArrayList<>();
        announceBoardEntities.forEach((a) -> {
            UserEntity u = a.getUserEntity();
            BookEntity b = a.getBookEntity();
            announceDataResponses.add(new AnnounceDataResponse(
                    a.getId(),
                    u.getFirstName(),
                    u.getLastName(),
                    b.getName(),
                    b.getGenre(),
                    b.getAuthor(),
                    b.getYear(),
                    a.getAnnounceTimeStamp()
            ));
        });
        return new ResponseEntity<>(announceDataResponses, HttpStatus.OK);
    }

}
