package spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;
import ru.otus.spring.domain.Student;
import ru.otus.spring.service.localization.LocalizationServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentTestLocaleImplTest {
    private LocalizationServiceImpl localizationService;
    @Mock
    private MessageSource messageSource;

    @BeforeEach
    void setUp() {
        localizationService = new LocalizationServiceImpl(messageSource);
    }

    @Test
    void shouldLocalizeMessage() {
        Student student = new Student("Foo", "Bar");

        String expectedMessage = String.format("Student %s %s answered %d questions out of %d correctly!",
                student.getName().toUpperCase(),
                student.getSurname().toUpperCase(),
                5,
                5);
        when(localizationService.getMessage("result.student-test.message",
                new String[]{student.getName().toUpperCase(),
                        student.getSurname().toUpperCase(),
                        "5",
                        "5"
                }
        )).thenReturn(expectedMessage);

        String actualMessage = localizationService.getMessage("result.student-test.message",
                new String[]{student.getName().toUpperCase(),
                        student.getSurname().toUpperCase(),
                        "5",
                        "5"
                }
        );

        assertThat(actualMessage).isEqualTo(expectedMessage);
    }
}