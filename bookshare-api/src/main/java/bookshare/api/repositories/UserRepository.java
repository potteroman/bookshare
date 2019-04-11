package bookshare.api.repositories;

import bookshare.api.entities.User;

public interface UserRepository {

    User insert(User user) throws ClassNotFoundException, Exception;

}