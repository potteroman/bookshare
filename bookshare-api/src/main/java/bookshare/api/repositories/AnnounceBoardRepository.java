package bookshare.api.repositories;
import java.util.List;
import java.sql.SQLException;
import bookshare.api.entities.AnnounceBoardEntity;

public interface AnnounceBoardRepository  {
    AnnounceBoardEntity insert(AnnounceBoardEntity announceBoard) throws ClassNotFoundException, Exception;
    public List<AnnounceBoardEntity> selectAll() throws SQLException;
}
