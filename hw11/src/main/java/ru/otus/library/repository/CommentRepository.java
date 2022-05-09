package ru.otus.library.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import ru.otus.library.model.Comment;


public interface CommentRepository extends ReactiveMongoRepository<Comment, String> {

}
