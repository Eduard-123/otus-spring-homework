package ru.otus.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.Student;
import ru.otus.spring.exception.ConsoleOutputException;
import ru.otus.spring.service.localization.LocalizationService;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final ConsoleOutputService consoleOutputService;
    private final LocalizationService localizationService;

    @Override
    public Student getStudent() throws ConsoleOutputException {
        return new Student(askStudentName(), askStudentSurname());
    }

    private String askStudentName() throws ConsoleOutputException {
        consoleOutputService.ask(localizationService.getMessage("student.name.message",null));
        return consoleOutputService.getAnswer();
    }

    private String askStudentSurname() throws ConsoleOutputException {
        consoleOutputService.ask(localizationService.getMessage("student.surname.message",null));
        return consoleOutputService.getAnswer();
    }


}
