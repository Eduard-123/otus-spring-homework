package ru.otus.parser;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.experimental.UtilityClass;
import ru.otus.model.Question;

import java.io.FileReader;
import java.util.List;

@UtilityClass
public class CSVParser {

    public static List<Question> parse(String path) {
        List<Question> questions = new CsvToBeanBuilder<Question>(new FileReader()).withType(Question.class).build().parse();
    }

}
