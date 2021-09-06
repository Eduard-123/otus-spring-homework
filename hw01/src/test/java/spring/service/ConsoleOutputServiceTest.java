package spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.exception.ConsoleOutputException;
import ru.otus.spring.service.ConsoleOutputServiceImpl;
import ru.otus.spring.service.localization.LocalizationService;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ConsoleOutputServiceTest {
    private ConsoleOutputServiceImpl consoleOutputService;
    private ByteArrayOutputStream outputStream;

    @Mock
    private InputStream systemIn;

    @Mock
    private LocalizationService localizationService;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        consoleOutputService = new ConsoleOutputServiceImpl(printStream, systemIn,localizationService);
    }

    @Test
    void shouldAskSomething() {
        consoleOutputService.ask("How much is the fish?");
        assertEquals(outputStream.toString(), "How much is the fish?" + "\r\n");
    }

    @Test
    void shouldThrowException() {
        Exception exception = assertThrows(ConsoleOutputException.class, () -> {
            consoleOutputService.getAnswer();
        });

        assertEquals(exception.getClass(), ConsoleOutputException.class);
    }
}