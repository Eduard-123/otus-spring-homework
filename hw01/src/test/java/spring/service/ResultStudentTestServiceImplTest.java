package spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.domain.ResultStudentTest;
import ru.otus.spring.domain.Student;
import ru.otus.spring.service.ConsoleOutputService;
import ru.otus.spring.service.ResultStudentTestServiceImpl;
import ru.otus.spring.service.localization.LocalizationService;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ResultStudentTestServiceImplTest {
    private ResultStudentTestServiceImpl resultStudentTestService;

    @Mock
    private ConsoleOutputService consoleOutputService;
    @Mock
    private LocalizationService localizationService;

    @BeforeEach
    void setUp() {
        resultStudentTestService = new ResultStudentTestServiceImpl(consoleOutputService, localizationService);
    }

    @Test
    void resultStudentTest() {
        ResultStudentTest result = createResultStudentTest();

        String question = String.format("Student %s %s answered %s questions out of %s correctly!",
                result.getStudent().getName().toUpperCase(),
                result.getStudent().getSurname().toUpperCase(),
                result.getCorrectAnswersCount(),
                result.getQuestionCount()
        );
        when(localizationService.getMessage("result.student-test.message",
                new String[]{result.getStudent().getName().toUpperCase(),
                        result.getStudent().getSurname().toUpperCase(),
                        String.valueOf(result.getCorrectAnswersCount()),
                        String.valueOf(result.getQuestionCount())
                }
        )).thenReturn(question);

        resultStudentTestService.resultStudentTest(result);

        Mockito.verify(consoleOutputService, Mockito.times(1)).ask(question);
    }

    private ResultStudentTest createResultStudentTest() {
        Student student = new Student("Spongebob","Square pants");
        return new ResultStudentTest(student, 5, 5);
    }
}