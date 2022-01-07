package ru.otus.library.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library.model.Genre;

public interface GenreService {
    Mono<Genre> getById(String id);
    Flux<Genre> getAll();
}
