package spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.spring.service.ValidateAnswerServiceImpl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidationServiceTest {

    private ValidateAnswerServiceImpl validateAnswerService;

    @BeforeEach
    void setUp() {
        validateAnswerService = new ValidateAnswerServiceImpl();
    }

    @Test
    void shouldReturnTrue() {
        boolean validate = validateAnswerService.validate("B", "B");

        assertTrue(validate);
    }

    @Test
    void shouldReturnFalse() {
        boolean validate = validateAnswerService.validate("B", "Q");

        assertFalse(validate);
    }
}