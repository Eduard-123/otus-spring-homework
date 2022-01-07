package ru.otus.library.service;

import ru.otus.library.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Optional<Author> getById(long id);
    List<Author> getAll();
}
