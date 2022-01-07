package ru.otus.library.service;

import ru.otus.library.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    Optional<Genre> getById(String id);
    List<Genre> getAll();
}
