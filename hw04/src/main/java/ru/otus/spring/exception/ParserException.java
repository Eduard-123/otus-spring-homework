package ru.otus.spring.exception;

public class ParserException extends RuntimeException {

    public ParserException(String message) {
        super(message);
    }
}