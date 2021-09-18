package ru.otus.spring.service;

import ru.otus.spring.exception.ConsoleOutputException;


public interface ConsoleOutputService {

    void ask(String question);

    String getAnswer() throws ConsoleOutputException;
}
