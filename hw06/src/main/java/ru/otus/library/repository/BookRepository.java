package ru.otus.library.repository;



import ru.otus.library.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    int count();

    Book save(Book book);

    Optional<Book> getById(long id);

    List<Book> getAll();

    void deleteById(long id);
}
