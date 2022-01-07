package ru.otus.library.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library.model.Author;

public interface AuthorService {
    Mono<Author> getById(String id);
    Flux<Author> getAll();
}
