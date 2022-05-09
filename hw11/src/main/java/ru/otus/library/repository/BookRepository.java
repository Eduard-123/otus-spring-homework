package ru.otus.library.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.model.Book;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {
}
