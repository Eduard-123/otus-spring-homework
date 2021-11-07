package ru.otus.library.domain;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:test-application.properties")
public class GenreDaoTest {

    @Autowired
    private GenreDao dao;

    @Test
    public void saveEntity() {
        Genre genre = new Genre();
        genre.setTitle("Fantasy");
        dao.insert(genre);
        Assertions.assertTrue(genre.getId() != 0);
    }

    @Test
    public void findSavedEntity() {
        Genre genre = new Genre();
        genre.setTitle("Some genre");
        dao.insert(genre);

        Genre storedEntity = dao.findByTitle("Some genre");

        assertNotSame(storedEntity, genre);
    }

    @Test
    public void findCollection() {
        List<Genre> genres = dao.getAll();
        assertTrue(genres.size() >= 3);
    }
}
