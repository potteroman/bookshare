package bookshare.api.controllers;

import bookshare.api.entities.AnnounceBoardEntity;
import bookshare.api.models.AnnounceAddRequest;
import bookshare.api.models.AnnounceAddResponse;
import bookshare.api.repositories.AnnounceBoardRepository;
import bookshare.api.repositories.impl.AnnounceBoardRepositoryImpl;
import bookshare.api.models.AnnounceDataResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin

public class AnnounceBoardController {
    private final AnnounceBoardRepository announceBoardRepository;


    public AnnounceBoardController() {
        this.announceBoardRepository = new AnnounceBoardRepositoryImpl();
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
    public List<AnnounceDataResponse> getAllUsers() throws SQLException {
        List<AnnounceDataResponse> announceBoardEntities = announceBoardRepository.selectAll2();
        return announceBoardEntities;
    }

}
