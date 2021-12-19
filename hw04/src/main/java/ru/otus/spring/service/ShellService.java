package ru.otus.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.domain.Student;
import ru.otus.spring.service.localization.LocalizationService;

@ShellComponent
@RequiredArgsConstructor
public class ShellService {

    private final StudentTestService studentTestService;
    private final LocalizationService localizationService;
    private Student student;

    @ShellMethod(value = "Start testing session", key = "start")
    @ShellMethodAvailability(value = "hasIntroduced")
    public void startTesting() {
        studentTestService.startTest(student);
    }

    @ShellMethod(value = "Set student name and surname", key = "introduce")
    public String setCurrentStudent(@ShellOption String name, @ShellOption String surname) {
        student = new Student(name,surname);
        return localizationService.getMessage("shell.service.welcome.message",new String[]{student.getName(),student.getSurname()});
    }

    private Availability hasIntroduced() {
        return student != null ? Availability.available() : Availability.unavailable(localizationService.getMessage("shell.service.no.preconditions.error",null));
    }

}
