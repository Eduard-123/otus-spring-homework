package ru.otus.library.domain;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:test-application.properties")
public class BookDaoTest {

    @Autowired
    BookDao dao;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    GenreDao genreDao;

    @Test
    public void registerBook() {
        Book book = new Book();
        book.setISBN("982164");
        book.setTitle("Title of book");

        book.addGenre(genreDao.getAll().get(0));
        book.addGenre(genreDao.getAll().get(1));

        book.addAuthor(authorDao.getAll().get(0));
        book.addAuthor(authorDao.getAll().get(1));
        book.addAuthor(authorDao.getAll().get(2));

        dao.insert(book);

        Book storedBook = dao.getByISBN("982164");
        Assertions.assertEquals(2,storedBook.getGenres().size() );
        Assertions.assertEquals(3,storedBook.getAuthors().size());
        Assertions.assertEquals("Title of book", storedBook.getTitle());
    }
}