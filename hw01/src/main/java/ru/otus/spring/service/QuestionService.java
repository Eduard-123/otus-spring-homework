package ru.otus.spring.service;

import ru.otus.spring.domain.Question;
import ru.otus.spring.exception.ParserException;
import ru.otus.spring.exception.QuestionDaoException;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions() throws ParserException, QuestionDaoException;

    void askQuestion(Question question);
}
