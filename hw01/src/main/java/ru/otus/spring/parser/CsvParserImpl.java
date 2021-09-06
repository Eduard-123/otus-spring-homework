package ru.otus.spring.parser;

import org.springframework.stereotype.Component;
import ru.otus.spring.domain.Question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class CsvParserImpl implements CsvParser {
    @Override
    public List<Question> parse(List<String[]> arrayList) {
        List<Question> result = new LinkedList<>();

        for (String[] array : arrayList) {

            List<String> answerList = getAnswersFrom(array);

            result.add(new Question(array[0], array[1], answerList));
        }

        return result;
    }

    private static List<String> getAnswersFrom(String[] array) {

        ArrayList<String> answers = new ArrayList<>() {{
            add(array[2]);
            add(array[3]);
            add(array[4]);
            add(array[5]);
        }};

        return answers;
    }
}
