package ru.otus.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.exception.ConsoleOutputException;

@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final ConsoleOutputService consoleOutputService;

    @Override
    public String getAnswer() throws ConsoleOutputException {
        return consoleOutputService.getAnswer();
    }
}
