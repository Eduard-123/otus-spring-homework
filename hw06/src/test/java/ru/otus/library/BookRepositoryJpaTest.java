package ru.otus.library;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import ru.otus.library.model.Author;
import ru.otus.library.model.Book;
import ru.otus.library.model.Genre;
import ru.otus.library.repository.BookRepositoryJpa;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Репозиторий на основе JPA для работы с книгами ")
@DataJpaTest
@Import(BookRepositoryJpa.class)
public class BookRepositoryJpaTest {

    private static final int EXPECTED_NUMBER_OF_BOOKS = 4;

    @Autowired
    private BookRepositoryJpa bookRepository;

    @DisplayName("должен выдавать корректное количество книг")
    @Test
    void shouldReturnCorrectCountOfAllBooks() {
        var count = bookRepository.count();
        assertEquals(EXPECTED_NUMBER_OF_BOOKS, count);
    }

    @DisplayName("должен загружать список всех книг с полной информацией о них")
    @Test
    void shouldReturnCorrectGenresListWithAllInfo() {
        var books = bookRepository.getAll();
        for (Book book : books) {
            assertNotEquals(0L, book.getId());
            assertNotNull(book.getName());
            assertNotNull(book.getGenre());
            assertNotNull(book.getComments());
        }
    }

    @DisplayName("должен выдавать корректный идентификатор новой книги при вставке")
    @Test
    void shouldReturnCorrectBookIdWhenInsertedNew() {
        Book book = new Book(0, "Test", new Author(1,null), new Genre(1,null));

        Book saved = bookRepository.save(book);
        assertTrue(saved.getId() > 0);
    }

    @DisplayName("должен изменить книгу при обновлении")
    @Test
    void shouldCorrectUpdateBook() {
        Book book = new Book(1,"Test", new Author(1,null), new Genre(1,null));

        Book updated = bookRepository.save(book);

        assertEquals(1, updated.getId());
        assertEquals(1, updated.getAuthor().getId());
        assertEquals(1, updated.getGenre().getId());
    }

    @DisplayName("должен выдавать книгу по существующему идентификатору")
    @Test
    void shouldReturnBookWhenIdExists() {
        Book book = bookRepository.getById(1).get();

        assertNotNull(book);
    }

    @DisplayName("должен выдавать Empty по несуществующему идентификатору")
    @Test
    void shouldReturnEmptyWhenIdNotExists() {
        var book = bookRepository.getById(-1);

        assertTrue(book.isEmpty());
    }

    @DisplayName("должен удалять книгу по существующему идентификатору")
    @Test
    void shouldDeleteBookWhenIdExists() {
        long id = 1;

        bookRepository.deleteById(id);

        assertTrue(bookRepository.getById(id).isEmpty());
    }
}
