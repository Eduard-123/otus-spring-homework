package ru.otus.spring.parser;

import au.com.bytecode.opencsv.CSVReader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.spring.exception.ParserException;
import ru.otus.spring.service.localization.LocalizationService;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Component
@AllArgsConstructor
public class InputStreamParserImpl implements InputStreamParser {

    private LocalizationService localizationService;

    @Override
    public List<String[]> parse(InputStream stream) throws ParserException {
        try (CSVReader questionFile = new CSVReader(new InputStreamReader(stream), ';', '"')) {
            return questionFile.readAll();
        } catch (Exception e) {
            throw new ParserException(localizationService.getMessage("error.parsing.csv",null));
        }
    }
}
