package ru.otus.spring.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.otus.spring.domain.Question;
import ru.otus.spring.exception.ParserException;
import ru.otus.spring.exception.QuestionDaoException;
import ru.otus.spring.parser.CsvParser;
import ru.otus.spring.parser.InputStreamParser;
import ru.otus.spring.service.localization.LocalizationService;

import java.io.InputStream;
import java.util.List;

@Component
public class QuestionDaoImpl implements QuestionDao {

    private final String resourceFile;
    private final InputStreamParser inputStreamParser;
    private final CsvParser csvParser;
    private final LocalizationService localizationService;

    public QuestionDaoImpl(@Value("${question.file.name}") String resourceFile, InputStreamParser inputStreamParser, CsvParser csvParser, LocalizationService localizationService) {
        this.resourceFile = resourceFile;
        this.inputStreamParser = inputStreamParser;
        this.csvParser = csvParser;
        this.localizationService = localizationService;
    }

    @Override
    public List<Question> getQuestions() throws QuestionDaoException, ParserException {
        InputStream streamFromResource = this.getClass().getClassLoader().getResourceAsStream(resourceFile);

        if (streamFromResource == null) {
            throw new QuestionDaoException(localizationService.getMessage("resource.file.not.found",null));
        }

        return getQuestionListFromStream(streamFromResource);
    }

    private List<Question> getQuestionListFromStream(InputStream streamFromResource) throws ParserException {
        List<String[]> arrayList = inputStreamParser.parse(streamFromResource);
        return csvParser.parse(arrayList);
    }
}
