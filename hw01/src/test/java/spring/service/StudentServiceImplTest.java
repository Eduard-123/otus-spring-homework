package spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.domain.Student;
import ru.otus.spring.exception.ConsoleOutputException;
import ru.otus.spring.service.ConsoleOutputService;
import ru.otus.spring.service.StudentServiceImpl;
import ru.otus.spring.service.localization.LocalizationService;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {
    private StudentServiceImpl studentService;
    @Mock
    private ConsoleOutputService consoleOutputService;
    @Mock
    private LocalizationService localizationService;


    @BeforeEach
    void setUp() {
        studentService = new StudentServiceImpl(consoleOutputService, localizationService);
    }

    @Test
    void getStudent() throws ConsoleOutputException {
        Student expectedStudent = new Student("Foo", "Bar");
        Mockito.when(consoleOutputService.getAnswer())
                .thenReturn(expectedStudent.getName())
                .thenReturn(expectedStudent.getSurname());

        Student student = studentService.getStudent();

        assertThat(student).usingRecursiveComparison().isEqualTo(expectedStudent);
    }
}