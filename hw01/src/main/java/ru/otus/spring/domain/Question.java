package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Question {
    private final String rightAnswer;
    private final String question;
    private final List<String> answer;
}
