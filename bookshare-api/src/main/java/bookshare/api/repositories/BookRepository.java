package bookshare.api.repositories;

import bookshare.api.entities.BookEntity;

public interface BookRepository  {

    BookEntity insert(BookEntity book) throws ClassNotFoundException, Exception;

}