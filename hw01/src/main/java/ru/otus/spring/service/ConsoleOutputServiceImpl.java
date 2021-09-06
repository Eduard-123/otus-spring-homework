package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.spring.exception.ConsoleOutputException;
import ru.otus.spring.service.localization.LocalizationService;

import java.io.*;

@Service
public class ConsoleOutputServiceImpl implements ConsoleOutputService {

    private final PrintStream systemOut;
    private final BufferedReader reader;
    private final LocalizationService localizationService;
    public ConsoleOutputServiceImpl(@Value("#{T(java.lang.System).out}") PrintStream systemOut,
                                    @Value("#{T(java.lang.System).in}") InputStream systemIn, LocalizationService localizationService) {
        this.systemOut = systemOut;
        this.reader = new BufferedReader(new InputStreamReader(systemIn));
        this.localizationService = localizationService;
    }

    @Override
    public void ask(String question) {
        systemOut.println(question);
    }

    @Override
    public String getAnswer() throws ConsoleOutputException {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new ConsoleOutputException(localizationService.getMessage("error.reading.from.console",null));
        }
    }
}
