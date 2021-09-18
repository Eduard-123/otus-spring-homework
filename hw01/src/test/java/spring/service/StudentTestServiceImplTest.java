package spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.domain.Question;
import ru.otus.spring.domain.ResultStudentTest;
import ru.otus.spring.domain.Student;
import ru.otus.spring.exception.ConsoleOutputException;
import ru.otus.spring.exception.ParserException;
import ru.otus.spring.exception.QuestionDaoException;
import ru.otus.spring.service.*;
import ru.otus.spring.service.localization.LocalizationService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentTestServiceImplTest {
    private StudentTestServiceImpl studentTestService;

    @Mock
    private StudentService studentService;
    @Mock
    private QuestionService questionService;
    @Mock
    private AnswerService answerService;
    @Mock
    private ValidateAnswerService validateAnswerService;
    @Mock
    private ResultStudentTestService resultService;

    private List<Question> questions;
    private Question question;

    @BeforeEach
    void setUp() {
        studentTestService = new StudentTestServiceImpl(questionService, studentService, answerService, validateAnswerService, resultService);
        questions = new ArrayList<>();
        question = new Question("A",
                "Which of the following is an example of physics at work in a smart phone?",
                getAnswerList());
        questions.add(question);
    }

    @Test
    void shouldTestStudent() throws ConsoleOutputException, ParserException, QuestionDaoException {
        Student student = new Student("Foo", "Bar");
        when(studentService.getStudent()).thenReturn(student);

        when(questionService.getAllQuestions()).thenReturn(questions);
        String answer = "B";
        when(answerService.getAnswer()).thenReturn(answer);
        when(validateAnswerService.validate(questions.get(0).getRightAnswer(), answer)).thenReturn(true);

        studentTestService.startTest();

        verify(resultService).resultStudentTest(any(ResultStudentTest.class));
    }

    private static List<String> getAnswerList() {
        List<String> result = new ArrayList<>();

        result.add(" A - All of these answers");
        result.add(" B - Equations used in GPS");
        result.add(" C - Electricity used in circuit boards");
        result.add(" D - Electromagnets used in speakers");

        return result;
    }
}