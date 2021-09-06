package ru.otus.spring.service;

import ru.otus.spring.domain.Student;
import ru.otus.spring.exception.ConsoleOutputException;


public interface StudentService {
    Student getStudent() throws ConsoleOutputException;
}
