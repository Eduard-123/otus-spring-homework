package ru.otus.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.Question;
import ru.otus.spring.domain.ResultStudentTest;
import ru.otus.spring.domain.Student;
import ru.otus.spring.exception.ConsoleOutputException;
import ru.otus.spring.exception.ParserException;
import ru.otus.spring.exception.QuestionDaoException;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentTestServiceImpl implements StudentTestService {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private final ValidateAnswerService validateAnswerService;
    private final ResultStudentTestService resultService;

    @Override
    public void startTest(Student student) {
        int countRightAnswer = 0;

        List<Question> allQuestion = questionService.getAllQuestions();
        for (Question question : allQuestion) {
            questionService.askQuestion(question);
            String answer = answerService.getAnswer();
            if (validateAnswerService.validate(question.getRightAnswer(), answer)) {
                countRightAnswer++;
            }
        }

        resultService.resultStudentTest(new ResultStudentTest(student, allQuestion.size(), countRightAnswer));
    }
}
