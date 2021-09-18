package ru.otus.spring.dao;

import ru.otus.spring.domain.Question;
import ru.otus.spring.exception.ParserException;
import ru.otus.spring.exception.QuestionDaoException;

import java.util.List;

public interface QuestionDao {
    List<Question> getQuestions() throws QuestionDaoException, ParserException;
}
