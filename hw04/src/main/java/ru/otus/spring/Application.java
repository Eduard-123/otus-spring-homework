package ru.otus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.otus.spring.exception.ConsoleOutputException;
import ru.otus.spring.exception.ParserException;
import ru.otus.spring.exception.QuestionDaoException;
import ru.otus.spring.service.StudentTestService;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws ParserException, QuestionDaoException, ConsoleOutputException {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        context.close();
    }
}