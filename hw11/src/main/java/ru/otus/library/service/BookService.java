package ru.otus.library.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library.dto.BookDto;
import ru.otus.library.dto.CommentDto;
import ru.otus.library.model.Book;

public interface BookService {
    Flux<BookDto> getAll();

    Mono<BookDto> find(String id);

    Mono<BookDto> save(Book book);

    Mono<Void> delete(Book book);

    Mono<CommentDto> getComments(Book book);

    Mono<CommentDto> addComment(Book book, String text);
}
