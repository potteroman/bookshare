package bookshare.api.controllers;

import bookshare.api.entities.AnnounceBoardEntity;
import bookshare.api.models.AnnounceAddRequest;
import bookshare.api.models.AnnounceAddResponse;
import bookshare.api.repositories.AnnounceBoardRepository;
import bookshare.api.repositories.impl.AnnounceBoardRepositoryImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin

public class AnnounceBoardController {
    private final AnnounceBoardRepository announceBoardRepository;

    public AnnounceBoardController() {
        this.announceBoardRepository = new AnnounceBoardRepository() {
            @Override
            public AnnounceBoardEntity insert(AnnounceBoardEntity announceBoard) throws ClassNotFoundException, Exception {
                return null;
            }
        };
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

        return AnnounceAddResponse;
    }

}
