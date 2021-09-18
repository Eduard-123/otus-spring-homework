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
    private final StudentService studentService;
    private final AnswerService answerService;
    private final ValidateAnswerService validateAnswerService;
    private final ResultStudentTestService resultService;

    @Override
    public void startTest() throws ConsoleOutputException, ParserException, QuestionDaoException {
        int countRightAnswer = 0;
        Student student = studentService.getStudent();

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
