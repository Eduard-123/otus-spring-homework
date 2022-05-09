package ru.otus.library.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.otus.library.model.Author;
import ru.otus.library.service.AuthorService;

@RestController
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/api/author")
    public Flux<Author> getAll() {
        return authorService.getAll();
    }
}
