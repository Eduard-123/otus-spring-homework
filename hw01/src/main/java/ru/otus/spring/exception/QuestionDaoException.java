package ru.otus.spring.exception;

public class QuestionDaoException extends RuntimeException {

    public QuestionDaoException(String message) {
        super(message);
    }
}
