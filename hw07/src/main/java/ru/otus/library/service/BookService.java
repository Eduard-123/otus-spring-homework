package ru.otus.library.service;
import ru.otus.library.dto.BookDto;
import ru.otus.library.dto.CommentDto;
import ru.otus.library.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDto> getAll();

    Optional<BookDto> find(long id);

    BookDto save(Book book);

    void delete(Book book);

    List<CommentDto> getComments(Book book);

    CommentDto addComment(Book book, String text);
}
