package ru.otus.spring.service;

import ru.otus.spring.exception.ConsoleOutputException;

public interface AnswerService {
    String getAnswer() throws ConsoleOutputException;
}
