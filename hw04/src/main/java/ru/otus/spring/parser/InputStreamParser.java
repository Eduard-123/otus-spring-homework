package ru.otus.spring.parser;

import ru.otus.spring.exception.ParserException;

import java.io.InputStream;
import java.util.List;

public interface InputStreamParser {
    List<String[]> parse(InputStream stream) throws ParserException;
}