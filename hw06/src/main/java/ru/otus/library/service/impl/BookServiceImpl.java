package ru.otus.library.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.model.Book;
import ru.otus.library.model.Comment;
import ru.otus.library.repository.BookRepository;
import ru.otus.library.service.BookNotFoundException;
import ru.otus.library.service.BookSaveException;
import ru.otus.library.service.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Book> find(long id) {
        return bookRepository.getById(id);
    }

    @Transactional
    @Override
    public Book save(Book book) {
        try {
            return bookRepository.save(book);
        } catch (Exception e) {
            throw new BookSaveException(String.format("Error on save book: %s, %s", book, e.getMessage()));
        }
    }

    @Transactional
    @Override
    public void delete(Book book) {
        bookRepository.deleteById(book.getId());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> getComments(Book book) {
        Book reloaded = find(book.getId()).orElseThrow(BookNotFoundException::new);
        return reloaded.getComments();
    }

    @Transactional
    @Override
    public Comment addComment(Book book, String text) {
        Book reloaded = bookRepository.getById(book.getId())
                .orElseThrow(BookNotFoundException::new);

        Comment comment = new Comment();
        comment.setValue(text);
        comment.setBook(reloaded);

        reloaded.getComments().add(comment);
        bookRepository.save(reloaded);

        return comment;
    }
}
