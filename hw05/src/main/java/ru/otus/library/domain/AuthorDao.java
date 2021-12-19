package ru.otus.library.domain;

import java.util.List;

public interface AuthorDao {
    Author getById(long id);

    List<Author> getAll();

    Author getByName(String s);

    void insert(Author entity);
}
