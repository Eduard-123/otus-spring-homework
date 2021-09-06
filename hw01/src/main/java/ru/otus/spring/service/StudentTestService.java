package ru.otus.spring.service;

import ru.otus.spring.exception.ConsoleOutputException;
import ru.otus.spring.exception.ParserException;
import ru.otus.spring.exception.QuestionDaoException;

public interface StudentTestService {
    void startTest() throws ConsoleOutputException, ParserException, QuestionDaoException;
}
