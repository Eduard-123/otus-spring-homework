package ru.otus.library.domain;

import java.util.List;

public interface GenreDao {
    Genre getById(long id);

    List<Genre> getAll();

    Genre findByTitle(String s);

    void insert(Genre entity);
}
