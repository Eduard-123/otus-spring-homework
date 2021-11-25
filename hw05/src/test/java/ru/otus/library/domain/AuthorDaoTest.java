package ru.otus.library.domain;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotSame;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:test-application.properties")
public class AuthorDaoTest {

    @Autowired
    private AuthorDao dao;

    @Test
    public void saveEntity() {
        Author author = new Author();
        author.setName("Author");
        dao.insert(author);
        Assertions.assertNotEquals(0,author.getId());
    }

    @Test
    public void findSavedEntity() {
        Author author = new Author();
        author.setName("Some author");
        dao.insert(author);

        Author storedEntity = dao.getByName("Some author");

        assertNotSame(author, storedEntity);
        Assertions.assertEquals("Some author", storedEntity.getName());
    }

    @Test
    public void findCollection() {
        List<Author> authors = dao.getAll();
        Assertions.assertTrue(authors.size() >= 3);
    }
}
