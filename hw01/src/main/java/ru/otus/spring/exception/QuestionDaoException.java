package ru.otus.spring.exception;

import lombok.AllArgsConstructor;

public class QuestionDaoException extends Exception {

    public QuestionDaoException(String message) {
        super(message);
    }
}
