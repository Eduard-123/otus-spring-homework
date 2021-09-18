package ru.otus.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.domain.Question;
import ru.otus.spring.exception.ParserException;
import ru.otus.spring.exception.QuestionDaoException;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao questionDao;
    private final ConsoleOutputService consoleOutputService;

    @Override
    public List<Question> getAllQuestions() throws ParserException, QuestionDaoException {
        return questionDao.getQuestions();
    }

    @Override
    public void askQuestion(Question question) {
        consoleOutputService.ask(question.getQuestion());
        question.getAnswer().forEach(consoleOutputService::ask);
    }
}
