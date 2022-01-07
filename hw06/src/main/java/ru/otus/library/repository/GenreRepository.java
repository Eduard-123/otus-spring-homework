package ru.otus.library.repository;

import ru.otus.library.model.Genre;

import java.util.List;

public interface GenreRepository {
    List<Genre> getAll();
}
