package ru.otus.library.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.otus.library.model.Genre;
import ru.otus.library.service.GenreService;

@RestController
public class GenreRestController {

    private final GenreService genreService;

    public GenreRestController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/api/genre")
    public Flux<Genre> getAll() {
        return genreService.getAll();
    }
}
