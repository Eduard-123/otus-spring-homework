package ru.otus.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.library.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
