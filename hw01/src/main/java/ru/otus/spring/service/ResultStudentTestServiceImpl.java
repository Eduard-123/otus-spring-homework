package ru.otus.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.ResultStudentTest;
import ru.otus.spring.service.localization.LocalizationService;

@Service
@AllArgsConstructor
public class ResultStudentTestServiceImpl implements ResultStudentTestService {
    private final ConsoleOutputService consoleOutputService;
    private final LocalizationService localizationService;

    @Override
    public void resultStudentTest(ResultStudentTest result) {
        String resultTest = localizationService.getMessage("result.student-test.message",
                new String[]{result.getStudent().getName().toUpperCase(),
                        result.getStudent().getSurname().toUpperCase(),
                        String.valueOf(result.getCorrectAnswersCount()),
                        String.valueOf(result.getQuestionCount())
                }
        );

        consoleOutputService.ask(resultTest);
    }
}
