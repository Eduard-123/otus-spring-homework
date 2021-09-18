package spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.domain.Question;
import ru.otus.spring.exception.ParserException;
import ru.otus.spring.exception.QuestionDaoException;
import ru.otus.spring.service.ConsoleOutputService;
import ru.otus.spring.service.QuestionServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuestionServiceImplTest {
    private QuestionServiceImpl questionService;
    @Mock
    private QuestionDao questionDao;
    @Mock
    private ConsoleOutputService consoleOutputService;

    private List<Question> questions;
    private Question question;

    @BeforeEach
    void setUp() {
        questions = new ArrayList<>();
        questionService = new QuestionServiceImpl(questionDao, consoleOutputService);
        question = new Question("A",
                "Which of the following is an example of physics at work in a smart phone?",
                getAnswerList());
        questions.add(question);
    }

    @Test
    void shouldReturnQuestionList() throws ParserException, QuestionDaoException {
        when(questionDao.getQuestions()).thenReturn(questions);

        List<Question> allQuestion = questionService.getAllQuestions();

        assertEquals(questions, allQuestion);
    }

    @Test
    void shouldAskQuestionAndShowAnswer() {
        questionService.askQuestion(question);

        verify(consoleOutputService).ask(question.getQuestion());
    }

    private static List<String> getAnswerList() {
        List<String> result = new ArrayList<>(4);

        result.add(" A - All of these answers");
        result.add(" B - Equations used in GPS");
        result.add(" C - Electricity used in circuit boards");
        result.add(" D - Electromagnets used in speakers");

        return result;
    }
}