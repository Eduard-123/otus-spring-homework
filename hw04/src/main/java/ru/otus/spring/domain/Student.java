package ru.otus.spring.domain;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class Student {
    private final String name;
    private final String surname;
}
