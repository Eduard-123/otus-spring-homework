package ru.otus.spring.parser;

import ru.otus.spring.domain.Question;

import java.util.List;

public interface CsvParser {
    List<Question> parse(List<String[]> arrayList);
}
