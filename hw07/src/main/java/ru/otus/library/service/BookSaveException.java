package ru.otus.library.service;

public class BookSaveException extends RuntimeException {
    public BookSaveException(String message) {
        super(message);
    }
}
