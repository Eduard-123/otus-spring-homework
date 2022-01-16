package ru.otus.library.repository;

import ru.otus.library.model.Author;

import java.util.List;

public interface AuthorRepository {
    List<Author> getAll();
}
